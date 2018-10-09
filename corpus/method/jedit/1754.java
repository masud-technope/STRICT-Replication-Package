public void visitMultiANewArrayInsn(final String desc, final int dims) {
    if (computeMaxs) {
        // updates current stack size (max stack size unchanged because stack
        // size variation always negative or null)
        stackSize += 1 - dims;
    }
    // adds the instruction to the bytecode of the method
    Item classItem = cw.newClass(desc);
    code.put12(Constants.MULTIANEWARRAY, classItem.index).put1(dims);
}