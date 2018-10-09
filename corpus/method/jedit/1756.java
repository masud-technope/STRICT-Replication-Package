public void visitMaxs(final int maxStack, final int maxLocals) {
    if (computeMaxs) {
        // true (non relative) max stack size
        int max = 0;
        // control flow analysis algorithm: while the block stack is not empty,
        // pop a block from this stack, update the max stack size, compute
        // the true (non relative) begin stack size of the successors of this
        // block, and push these successors onto the stack (unless they have
        // already been pushed onto the stack). Note: by hypothesis, the {@link
        // Label#beginStackSize} of the blocks in the block stack are the true
        // (non relative) beginning stack sizes of these blocks.
        Label stack = blockStack;
        while (stack != null) {
            // pops a block from the stack
            Label l = stack;
            stack = stack.next;
            // computes the true (non relative) max stack size of this block
            int start = l.beginStackSize;
            int blockMax = start + l.maxStackSize;
            // updates the global max stack size
            if (blockMax > max) {
                max = blockMax;
            }
            // analyses the successors of the block
            Edge b = l.successors;
            while (b != null) {
                l = b.successor;
                // if this successor has not already been pushed onto the stack...
                if (!l.pushed) {
                    // computes the true beginning stack size of this successor block
                    l.beginStackSize = start + b.stackSize;
                    // pushes this successor onto the stack
                    l.pushed = true;
                    l.next = stack;
                    stack = l;
                }
                b = b.next;
            }
        }
        this.maxStack = max;
        // releases all the Edge objects used by this CodeWriter
        synchronized (SIZE) {
            // appends the [head ... tail] list at the beginning of the pool list
            if (tail != null) {
                tail.poolNext = pool;
                pool = head;
            }
        }
    } else {
        this.maxStack = maxStack;
        this.maxLocals = maxLocals;
    }
}