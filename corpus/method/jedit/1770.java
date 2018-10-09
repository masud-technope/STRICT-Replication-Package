// --------------------------------------------------------------------------
// Utility methods: instruction resizing (used to handle GOTO_W and JSR_W)
// --------------------------------------------------------------------------
/**
   * Resizes the designated instructions, while keeping jump offsets and
   * instruction addresses consistent. This may require to resize other existing
   * instructions, or even to introduce new instructions: for example,
   * increasing the size of an instruction by 2 at the middle of a method can
   * increases the offset of an IFEQ instruction from 32766 to 32768, in which
   * case IFEQ 32766 must be replaced with IFNEQ 8 GOTO_W 32765. This, in turn,
   * may require to increase the size of another jump instruction, and so on...
   * All these operations are handled automatically by this method.
   * <p>
   * <i>This method must be called after all the method that is being built has
   * been visited</i>. In particular, the {@link Label Label} objects used to
   * construct the method are no longer valid after this method has been called.
   *
   * @param indexes current positions of the instructions to be resized. Each
   *      instruction must be designated by the index of its <i>last</i> byte,
   *      plus one (or, in other words, by the index of the <i>first</i> byte of
   *      the <i>next</i> instruction).
   * @param sizes the number of bytes to be <i>added</i> to the above
   *      instructions. More precisely, for each i &lt; <tt>len</tt>,
   *      <tt>sizes</tt>[i] bytes will be added at the end of the instruction
   *      designated by <tt>indexes</tt>[i] or, if <tt>sizes</tt>[i] is
   *      negative, the <i>last</i> |<tt>sizes[i]</tt>| bytes of the instruction
   *      will be removed (the instruction size <i>must not</i> become negative
   *      or null). The gaps introduced by this method must be filled in
   *      "manually" in the array returned by the {@link #getCode getCode}
   *      method.
   * @param len the number of instruction to be resized. Must be smaller than or
   *      equal to <tt>indexes</tt>.length and <tt>sizes</tt>.length.
   * @return the <tt>indexes</tt> array, which now contains the new positions of
   *      the resized instructions (designated as above).
   */
protected int[] resizeInstructions(final int[] indexes, final int[] sizes, final int len) {
    // bytecode of the method
    byte[] b = code.data;
    // indexes in b
    int u, v, label;
    // loop indexes
    int i, j;
    // 1st step:
    // As explained above, resizing an instruction may require to resize another
    // one, which may require to resize yet another one, and so on. The first
    // step of the algorithm consists in finding all the instructions that
    // need to be resized, without modifying the code. This is done by the
    // following "fix point" algorithm:
    // - parse the code to find the jump instructions whose offset will need
    //   more than 2 bytes to be stored (the future offset is computed from the
    //   current offset and from the number of bytes that will be inserted or
    //   removed between the source and target instructions). For each such
    //   instruction, adds an entry in (a copy of) the indexes and sizes arrays
    //   (if this has not already been done in a previous iteration!)
    // - if at least one entry has been added during the previous step, go back
    //   to the beginning, otherwise stop.
    // In fact the real algorithm is complicated by the fact that the size of
    // TABLESWITCH and LOOKUPSWITCH instructions depends on their position in
    // the bytecode (because of padding). In order to ensure the convergence of
    // the algorithm, the number of bytes to be added or removed from these
    // instructions is over estimated during the previous loop, and computed
    // exactly only after the loop is finished (this requires another pass to
    // parse the bytecode of the method).
    // copy of indexes
    int[] allIndexes = new int[len];
    // copy of sizes
    int[] allSizes = new int[len];
    // instructions to be resized
    boolean[] resize;
    // future offset of a jump instruction
    int newOffset;
    System.arraycopy(indexes, 0, allIndexes, 0, len);
    System.arraycopy(sizes, 0, allSizes, 0, len);
    resize = new boolean[code.length];
    // 3 = loop again, 2 = loop ended, 1 = last pass, 0 = done
    int state = 3;
    do {
        if (state == 3) {
            state = 2;
        }
        u = 0;
        while (u < b.length) {
            // opcode of current instruction
            int opcode = b[u] & 0xFF;
            // bytes to be added after this instruction
            int insert = 0;
            switch(ClassWriter.TYPE[opcode]) {
                case ClassWriter.NOARG_INSN:
                case ClassWriter.IMPLVAR_INSN:
                    u += 1;
                    break;
                case ClassWriter.LABEL_INSN:
                    if (opcode > 201) {
                        // converts temporary opcodes 202 to 217 (inclusive), 218 and 219
                        // to IFEQ ... JSR (inclusive), IFNULL and IFNONNULL
                        opcode = opcode < 218 ? opcode - 49 : opcode - 20;
                        label = u + readUnsignedShort(b, u + 1);
                    } else {
                        label = u + readShort(b, u + 1);
                    }
                    newOffset = getNewOffset(allIndexes, allSizes, u, label);
                    if (newOffset < Short.MIN_VALUE || newOffset > Short.MAX_VALUE) {
                        if (!resize[u]) {
                            if (opcode == Constants.GOTO || opcode == Constants.JSR) {
                                // two additional bytes will be required to replace this
                                // GOTO or JSR instruction with a GOTO_W or a JSR_W
                                insert = 2;
                            } else {
                                // five additional bytes will be required to replace this
                                // IFxxx <l> instruction with IFNOTxxx <l'> GOTO_W <l>, where
                                // IFNOTxxx is the "opposite" opcode of IFxxx (i.e., IFNE for
                                // IFEQ) and where <l'> designates the instruction just after
                                // the GOTO_W.
                                insert = 5;
                            }
                            resize[u] = true;
                        }
                    }
                    u += 3;
                    break;
                case ClassWriter.LABELW_INSN:
                    u += 5;
                    break;
                case ClassWriter.TABL_INSN:
                    if (state == 1) {
                        // true number of bytes to be added (or removed) from this
                        // instruction = (future number of padding bytes - current number
                        // of padding byte) - previously over estimated variation =
                        // = ((3 - newOffset%4) - (3 - u%4)) - u%4
                        // = (-newOffset%4 + u%4) - u%4
                        // = -(newOffset & 3)
                        newOffset = getNewOffset(allIndexes, allSizes, 0, u);
                        insert = -(newOffset & 3);
                    } else if (!resize[u]) {
                        // over estimation of the number of bytes to be added to this
                        // instruction = 3 - current number of padding bytes = 3 - (3 -
                        // u%4) = u%4 = u & 3
                        insert = u & 3;
                        resize[u] = true;
                    }
                    // skips instruction
                    u = u + 4 - (u & 3);
                    u += 4 * (readInt(b, u + 8) - readInt(b, u + 4) + 1) + 12;
                    break;
                case ClassWriter.LOOK_INSN:
                    if (state == 1) {
                        // like TABL_INSN
                        newOffset = getNewOffset(allIndexes, allSizes, 0, u);
                        insert = -(newOffset & 3);
                    } else if (!resize[u]) {
                        // like TABL_INSN
                        insert = u & 3;
                        resize[u] = true;
                    }
                    // skips instruction
                    u = u + 4 - (u & 3);
                    u += 8 * readInt(b, u + 4) + 8;
                    break;
                case ClassWriter.WIDE_INSN:
                    opcode = b[u + 1] & 0xFF;
                    if (opcode == Constants.IINC) {
                        u += 6;
                    } else {
                        u += 4;
                    }
                    break;
                case ClassWriter.VAR_INSN:
                case ClassWriter.SBYTE_INSN:
                case ClassWriter.LDC_INSN:
                    u += 2;
                    break;
                case ClassWriter.SHORT_INSN:
                case ClassWriter.LDCW_INSN:
                case ClassWriter.FIELDORMETH_INSN:
                case ClassWriter.TYPE_INSN:
                case ClassWriter.IINC_INSN:
                    u += 3;
                    break;
                case ClassWriter.ITFMETH_INSN:
                    u += 5;
                    break;
                // case ClassWriter.MANA_INSN:
                default:
                    u += 4;
                    break;
            }
            if (insert != 0) {
                // adds a new (u, insert) entry in the allIndexes and allSizes arrays
                int[] newIndexes = new int[allIndexes.length + 1];
                int[] newSizes = new int[allSizes.length + 1];
                System.arraycopy(allIndexes, 0, newIndexes, 0, allIndexes.length);
                System.arraycopy(allSizes, 0, newSizes, 0, allSizes.length);
                newIndexes[allIndexes.length] = u;
                newSizes[allSizes.length] = insert;
                allIndexes = newIndexes;
                allSizes = newSizes;
                if (insert > 0) {
                    state = 3;
                }
            }
        }
        if (state < 3) {
            --state;
        }
    } while (state != 0);
    // 2nd step:
    // copies the bytecode of the method into a new bytevector, updates the
    // offsets, and inserts (or removes) bytes as requested.
    ByteVector newCode = new ByteVector(code.length);
    u = 0;
    while (u < code.length) {
        for (i = allIndexes.length - 1; i >= 0; --i) {
            if (allIndexes[i] == u) {
                if (i < len) {
                    if (sizes[i] > 0) {
                        newCode.putByteArray(null, 0, sizes[i]);
                    } else {
                        newCode.length += sizes[i];
                    }
                    indexes[i] = newCode.length;
                }
            }
        }
        int opcode = b[u] & 0xFF;
        switch(ClassWriter.TYPE[opcode]) {
            case ClassWriter.NOARG_INSN:
            case ClassWriter.IMPLVAR_INSN:
                newCode.put1(opcode);
                u += 1;
                break;
            case ClassWriter.LABEL_INSN:
                if (opcode > 201) {
                    // changes temporary opcodes 202 to 217 (inclusive), 218 and 219
                    // to IFEQ ... JSR (inclusive), IFNULL and IFNONNULL
                    opcode = opcode < 218 ? opcode - 49 : opcode - 20;
                    label = u + readUnsignedShort(b, u + 1);
                } else {
                    label = u + readShort(b, u + 1);
                }
                newOffset = getNewOffset(allIndexes, allSizes, u, label);
                if (newOffset < Short.MIN_VALUE || newOffset > Short.MAX_VALUE) {
                    // instruction just after the GOTO_W.
                    if (opcode == Constants.GOTO) {
                        // GOTO_W
                        newCode.put1(200);
                    } else if (opcode == Constants.JSR) {
                        // JSR_W
                        newCode.put1(201);
                    } else {
                        newCode.put1(opcode <= 166 ? ((opcode + 1) ^ 1) - 1 : opcode ^ 1);
                        // jump offset
                        newCode.put2(8);
                        // GOTO_W
                        newCode.put1(200);
                        // newOffset now computed from start of GOTO_W
                        newOffset -= 3;
                    }
                    newCode.put4(newOffset);
                } else {
                    newCode.put1(opcode);
                    newCode.put2(newOffset);
                }
                u += 3;
                break;
            case ClassWriter.LABELW_INSN:
                label = u + readInt(b, u + 1);
                newOffset = getNewOffset(allIndexes, allSizes, u, label);
                newCode.put1(opcode);
                newCode.put4(newOffset);
                u += 5;
                break;
            case ClassWriter.TABL_INSN:
                // skips 0 to 3 padding bytes
                v = u;
                u = u + 4 - (v & 3);
                // reads and copies instruction
                int source = newCode.length;
                newCode.put1(Constants.TABLESWITCH);
                while (newCode.length % 4 != 0) {
                    newCode.put1(0);
                }
                label = v + readInt(b, u);
                u += 4;
                newOffset = getNewOffset(allIndexes, allSizes, v, label);
                newCode.put4(newOffset);
                j = readInt(b, u);
                u += 4;
                newCode.put4(j);
                j = readInt(b, u) - j + 1;
                u += 4;
                newCode.put4(readInt(b, u - 4));
                for (; j > 0; --j) {
                    label = v + readInt(b, u);
                    u += 4;
                    newOffset = getNewOffset(allIndexes, allSizes, v, label);
                    newCode.put4(newOffset);
                }
                break;
            case ClassWriter.LOOK_INSN:
                // skips 0 to 3 padding bytes
                v = u;
                u = u + 4 - (v & 3);
                // reads and copies instruction
                source = newCode.length;
                newCode.put1(Constants.LOOKUPSWITCH);
                while (newCode.length % 4 != 0) {
                    newCode.put1(0);
                }
                label = v + readInt(b, u);
                u += 4;
                newOffset = getNewOffset(allIndexes, allSizes, v, label);
                newCode.put4(newOffset);
                j = readInt(b, u);
                u += 4;
                newCode.put4(j);
                for (; j > 0; --j) {
                    newCode.put4(readInt(b, u));
                    u += 4;
                    label = v + readInt(b, u);
                    u += 4;
                    newOffset = getNewOffset(allIndexes, allSizes, v, label);
                    newCode.put4(newOffset);
                }
                break;
            case ClassWriter.WIDE_INSN:
                opcode = b[u + 1] & 0xFF;
                if (opcode == Constants.IINC) {
                    newCode.putByteArray(b, u, 6);
                    u += 6;
                } else {
                    newCode.putByteArray(b, u, 4);
                    u += 4;
                }
                break;
            case ClassWriter.VAR_INSN:
            case ClassWriter.SBYTE_INSN:
            case ClassWriter.LDC_INSN:
                newCode.putByteArray(b, u, 2);
                u += 2;
                break;
            case ClassWriter.SHORT_INSN:
            case ClassWriter.LDCW_INSN:
            case ClassWriter.FIELDORMETH_INSN:
            case ClassWriter.TYPE_INSN:
            case ClassWriter.IINC_INSN:
                newCode.putByteArray(b, u, 3);
                u += 3;
                break;
            case ClassWriter.ITFMETH_INSN:
                newCode.putByteArray(b, u, 5);
                u += 5;
                break;
            // case MANA_INSN:
            default:
                newCode.putByteArray(b, u, 4);
                u += 4;
                break;
        }
    }
    // catch, local var and line number tables
    if (catchTable != null) {
        b = catchTable.data;
        u = 0;
        while (u < catchTable.length) {
            writeShort(b, u, getNewOffset(allIndexes, allSizes, 0, readUnsignedShort(b, u)));
            writeShort(b, u + 2, getNewOffset(allIndexes, allSizes, 0, readUnsignedShort(b, u + 2)));
            writeShort(b, u + 4, getNewOffset(allIndexes, allSizes, 0, readUnsignedShort(b, u + 4)));
            u += 8;
        }
    }
    if (localVar != null) {
        b = localVar.data;
        u = 0;
        while (u < localVar.length) {
            label = readUnsignedShort(b, u);
            newOffset = getNewOffset(allIndexes, allSizes, 0, label);
            writeShort(b, u, newOffset);
            label += readUnsignedShort(b, u + 2);
            newOffset = getNewOffset(allIndexes, allSizes, 0, label) - newOffset;
            writeShort(b, u, newOffset);
            u += 10;
        }
    }
    if (lineNumber != null) {
        b = lineNumber.data;
        u = 0;
        while (u < lineNumber.length) {
            writeShort(b, u, getNewOffset(allIndexes, allSizes, 0, readUnsignedShort(b, u)));
            u += 4;
        }
    }
    // replaces old bytecodes with new ones
    code = newCode;
    // returns the positions of the resized instructions
    return indexes;
}