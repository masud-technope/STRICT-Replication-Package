public void visitTryCatchBlock(final Label start, final Label end, final Label handler, final String type) {
    if (CHECK) {
        if (start.owner != this || end.owner != this || handler.owner != this) {
            throw new IllegalArgumentException();
        }
        if (!start.resolved || !end.resolved || !handler.resolved) {
            throw new IllegalArgumentException();
        }
    }
    if (computeMaxs) {
        // pushes handler block onto the stack of blocks to be visited
        if (!handler.pushed) {
            handler.beginStackSize = 1;
            handler.pushed = true;
            handler.next = blockStack;
            blockStack = handler;
        }
    }
    ++catchCount;
    if (catchTable == null) {
        catchTable = new ByteVector();
    }
    catchTable.put2(start.position);
    catchTable.put2(end.position);
    catchTable.put2(handler.position);
    catchTable.put2(type != null ? cw.newClass(type).index : 0);
}