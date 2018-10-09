public void visitJumpInsn(final int opcode, final Label label) {
    if (CHECK) {
        if (label.owner == null) {
            label.owner = this;
        } else if (label.owner != this) {
            throw new IllegalArgumentException();
        }
    }
    if (computeMaxs) {
        if (opcode == Constants.GOTO) {
            // no stack change, but end of current block (with one new successor)
            if (currentBlock != null) {
                currentBlock.maxStackSize = maxStackSize;
                addSuccessor(stackSize, label);
                currentBlock = null;
            }
        } else if (opcode == Constants.JSR) {
            if (currentBlock != null) {
                addSuccessor(stackSize + 1, label);
            }
        } else {
            // updates current stack size (max stack size unchanged because stack
            // size variation always negative in this case)
            stackSize += SIZE[opcode];
            if (currentBlock != null) {
                addSuccessor(stackSize, label);
            }
        }
    }
    // adds the instruction to the bytecode of the method
    if (label.resolved && label.position - code.length < Short.MIN_VALUE) {
        // instruction just after the GOTO_W.
        if (opcode == Constants.GOTO) {
            // GOTO_W
            code.put1(200);
        } else if (opcode == Constants.JSR) {
            // JSR_W
            code.put1(201);
        } else {
            code.put1(opcode <= 166 ? ((opcode + 1) ^ 1) - 1 : opcode ^ 1);
            // jump offset
            code.put2(8);
            // GOTO_W
            code.put1(200);
        }
        label.put(this, code, code.length - 1, true);
    } else {
        // case of a backward jump with an offset >= -32768, or of a forward jump
        // with, of course, an unknown offset. In these cases we store the offset
        // in 2 bytes (which will be increased in resizeInstructions, if needed).
        code.put1(opcode);
        label.put(this, code, code.length - 1, false);
    }
}