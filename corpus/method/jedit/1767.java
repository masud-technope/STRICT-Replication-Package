/**
   * Adds a successor to the {@link #currentBlock currentBlock} block.
   *
   * @param stackSize the current (relative) stack size in the current block.
   * @param successor the successor block to be added to the current block.
   */
private void addSuccessor(final int stackSize, final Label successor) {
    Edge b;
    // creates a new Edge object or reuses one from the shared pool
    synchronized (SIZE) {
        if (pool == null) {
            b = new Edge();
        } else {
            b = pool;
            // removes b from the pool
            pool = pool.poolNext;
        }
    }
    // adds the previous Edge to the list of Edges used by this CodeWriter
    if (tail == null) {
        tail = b;
    }
    b.poolNext = head;
    head = b;
    // initializes the previous Edge object...
    b.stackSize = stackSize;
    b.successor = successor;
    // ...and adds it to the successor list of the currentBlock block
    b.next = currentBlock.successors;
    currentBlock.successors = b;
}