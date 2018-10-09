public void visitLabel(final Label label) {
    if (CHECK) {
        if (label.owner == null) {
            label.owner = this;
        } else if (label.owner != this) {
            throw new IllegalArgumentException();
        }
    }
    if (computeMaxs) {
        if (currentBlock != null) {
            // ends current block (with one new successor)
            currentBlock.maxStackSize = maxStackSize;
            addSuccessor(stackSize, label);
        }
        // begins a new current block,
        // resets the relative current and max stack sizes
        currentBlock = label;
        stackSize = 0;
        maxStackSize = 0;
    }
    // resolves previous forward references to label, if any
    resize |= label.resolve(this, code.length, code.data);
}