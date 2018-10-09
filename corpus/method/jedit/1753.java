public void visitLookupSwitchInsn(final Label dflt, final int keys[], final Label labels[]) {
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
    code.put1(Constants.LOOKUPSWITCH);
    while (code.length % 4 != 0) {
        code.put1(0);
    }
    dflt.put(this, code, source, true);
    code.put4(labels.length);
    for (int i = 0; i < labels.length; ++i) {
        code.put4(keys[i]);
        labels[i].put(this, code, source, true);
    }
}