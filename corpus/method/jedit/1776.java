public void visitFieldInsn(final int opcode, final String owner, final String name, final String desc) {
    if (computeMaxs) {
        int size;
        // computes the stack size variation
        char c = desc.charAt(0);
        switch(opcode) {
            case Constants.GETSTATIC:
                size = stackSize + (c == 'D' || c == 'J' ? 2 : 1);
                break;
            case Constants.PUTSTATIC:
                size = stackSize + (c == 'D' || c == 'J' ? -2 : -1);
                break;
            case Constants.GETFIELD:
                size = stackSize + (c == 'D' || c == 'J' ? 1 : 0);
                break;
            //case Constants.PUTFIELD:
            default:
                size = stackSize + (c == 'D' || c == 'J' ? -3 : -2);
                break;
        }
        // updates current and max stack sizes
        if (size > maxStackSize) {
            maxStackSize = size;
        }
        stackSize = size;
    }
    // adds the instruction to the bytecode of the method
    code.put12(opcode, cw.newField(owner, name, desc).index);
}