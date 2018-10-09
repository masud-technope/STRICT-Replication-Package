public void visitTypeInsn(final int opcode, final String desc) {
    if (computeMaxs && opcode == Constants.NEW) {
        // updates current and max stack sizes only if opcode == NEW
        // (stack size variation = 0 for ANEWARRAY, CHECKCAST, INSTANCEOF)
        int size = stackSize + 1;
        if (size > maxStackSize) {
            maxStackSize = size;
        }
        stackSize = size;
    }
    // adds the instruction to the bytecode of the method
    code.put12(opcode, cw.newClass(desc).index);
}