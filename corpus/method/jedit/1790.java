/**
   * Resolves all forward references to this label. This method must be called
   * when this label is added to the bytecode of the method, i.e. when its
   * position becomes known. This method fills in the blanks that where left in
   * the bytecode by each forward reference previously added to this label.
   *
   * @param owner the code writer that calls this method.
   * @param position the position of this label in the bytecode.
   * @param data the bytecode of the method.
   * @return <tt>true</tt> if a blank that was left for this label was to small
   *      to store the offset. In such a case the corresponding jump instruction
   *      is replaced with a pseudo instruction (using unused opcodes) using an
   *      unsigned two bytes offset. These pseudo instructions will need to be
   *      replaced with true instructions with wider offsets (4 bytes instead of
   *      2). This is done in {@link CodeWriter#resizeInstructions}.
   * @throws IllegalArgumentException if this label has already been resolved,
   *      or if it has not been created by the given code writer.
   */
boolean resolve(final CodeWriter owner, final int position, final byte[] data) {
    if (CodeWriter.CHECK) {
        if (this.owner == null) {
            this.owner = owner;
        }
        if (resolved || this.owner != owner) {
            throw new IllegalArgumentException();
        }
    }
    boolean needUpdate = false;
    this.resolved = true;
    this.position = position;
    int i = 0;
    while (i < referenceCount) {
        int source = srcAndRefPositions[i++];
        int reference = srcAndRefPositions[i++];
        int offset;
        if (source >= 0) {
            offset = position - source;
            if (offset < Short.MIN_VALUE || offset > Short.MAX_VALUE) {
                // changes the opcode of the jump instruction, in order to be able to
                // find it later (see resizeInstructions in CodeWriter). These
                // temporary opcodes are similar to jump instruction opcodes, except
                // that the 2 bytes offset is unsigned (and can therefore represent
                // values from 0 to 65535, which is sufficient since the size of a
                // method is limited to 65535 bytes).
                int opcode = data[reference - 1] & 0xFF;
                if (opcode <= Constants.JSR) {
                    // changes IFEQ ... JSR to opcodes 202 to 217 (inclusive)
                    data[reference - 1] = (byte) (opcode + 49);
                } else {
                    // changes IFNULL and IFNONNULL to opcodes 218 and 219 (inclusive)
                    data[reference - 1] = (byte) (opcode + 20);
                }
                needUpdate = true;
            }
            data[reference++] = (byte) (offset >>> 8);
            data[reference] = (byte) offset;
        } else {
            offset = position + source + 1;
            data[reference++] = (byte) (offset >>> 24);
            data[reference++] = (byte) (offset >>> 16);
            data[reference++] = (byte) (offset >>> 8);
            data[reference] = (byte) offset;
        }
    }
    return needUpdate;
}