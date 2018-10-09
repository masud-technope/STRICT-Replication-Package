public void visitIntInsn(final int opcode, final int operand) {
    if (computeMaxs && opcode != Constants.NEWARRAY) {
        // updates current and max stack sizes only if opcode == NEWARRAY
        // (stack size variation = 0 for BIPUSH or SIPUSH)
        int size = stackSize + 1;
        if (size > maxStackSize) {
            maxStackSize = size;
        }
        stackSize = size;
    }
    // adds the instruction to the bytecode of the method
    if (opcode == Constants.SIPUSH) {
        code.put12(opcode, operand);
    } else {
        // BIPUSH or NEWARRAY
        code.put11(opcode, operand);
    }
}