public void visitVarInsn(final int opcode, final int var) {
    if (computeMaxs) {
        // updates current and max stack sizes
        if (opcode == Constants.RET) {
            // no stack change, but end of current block (no successor)
            if (currentBlock != null) {
                currentBlock.maxStackSize = maxStackSize;
                currentBlock = null;
            }
        } else {
            // xLOAD or xSTORE
            int size = stackSize + SIZE[opcode];
            if (size > maxStackSize) {
                maxStackSize = size;
            }
            stackSize = size;
        }
        // updates max locals
        int n;
        if (opcode == Constants.LLOAD || opcode == Constants.DLOAD || opcode == Constants.LSTORE || opcode == Constants.DSTORE) {
            n = var + 2;
        } else {
            n = var + 1;
        }
        if (n > maxLocals) {
            maxLocals = n;
        }
    }
    // adds the instruction to the bytecode of the method
    if (var < 4 && opcode != Constants.RET) {
        int opt;
        if (opcode < Constants.ISTORE) {
            opt = 26 + /*ILOAD_0*/
            ((opcode - Constants.ILOAD) << 2) + var;
        } else {
            opt = 59 + /*ISTORE_0*/
            ((opcode - Constants.ISTORE) << 2) + var;
        }
        code.put1(opt);
    } else if (var >= 256) {
        code.put1(196).put12(opcode, var);
    } else {
        code.put11(opcode, var);
    }
}