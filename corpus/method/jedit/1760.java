public void visitTableSwitchInsn(final int min, final int max, final Label dflt, final Label labels[]) {
    if (computeMaxs) {
        // updates current stack size (max stack size unchanged)
        --stackSize;
        // ends current block (with many new successors)
        if (currentBlock != null) {
            currentBlock.maxStackSize = maxStackSize;
            addSuccessor(stackSize, dflt);
            for (int i = 0; i < labels.length; ++i) {
                addSuccessor(stackSize, labels[i]);
            }
            currentBlock = null;
        }
    }
    // adds the instruction to the bytecode of the method
    int source = code.length;
    code.put1(Constants.TABLESWITCH);
    while (code.length % 4 != 0) {
        code.put1(0);
    }
    dflt.put(this, code, source, true);
    code.put4(min).put4(max);
    for (int i = 0; i < labels.length; ++i) {
        labels[i].put(this, code, source, true);
    }
}