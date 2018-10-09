public void visitIincInsn(final int var, final int increment) {
    if (computeMaxs) {
        // updates max locals only (no stack change)
        int n = var + 1;
        if (n > maxLocals) {
            maxLocals = n;
        }
    }
    // adds the instruction to the bytecode of the method
    if ((var > 255) || (increment > 127) || (increment < -128)) {
        code.put1(196).put12(Constants.IINC, var).put2(increment);
    } else {
        code.put1(Constants.IINC).put11(var, increment);
    }
}