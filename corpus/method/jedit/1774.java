protected  CodeWriter(final ClassWriter cw, final boolean computeMaxs) {
    if (cw.firstMethod == null) {
        cw.firstMethod = this;
        cw.lastMethod = this;
    } else {
        cw.lastMethod.next = this;
        cw.lastMethod = this;
    }
    this.cw = cw;
    this.computeMaxs = computeMaxs;
    if (computeMaxs) {
        // pushes the first block onto the stack of blocks to be visited
        currentBlock = new Label();
        currentBlock.pushed = true;
        blockStack = currentBlock;
    }
}