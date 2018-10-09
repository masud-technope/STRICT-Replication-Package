// --------------------------------------------------------------------------
// Implementation of the CodeVisitor interface
// --------------------------------------------------------------------------
public void visitInsn(final int opcode) {
    if (computeMaxs) {
        // updates current and max stack sizes
        int size = stackSize + SIZE[opcode];
        if (size > maxStackSize) {
            maxStackSize = size;
        }
        stackSize = size;
        // if opcode == ATHROW or xRETURN, ends current block (no successor)
        if ((opcode >= Constants.IRETURN && opcode <= Constants.RETURN) || opcode == Constants.ATHROW) {
            if (currentBlock != null) {
                currentBlock.maxStackSize = maxStackSize;
                currentBlock = null;
            }
        }
    }
    // adds the instruction to the bytecode of the method
    code.put1(opcode);
}