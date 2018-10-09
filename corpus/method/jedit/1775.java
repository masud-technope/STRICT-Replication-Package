public void visitMethodInsn(final int opcode, final String owner, final String name, final String desc) {
    Item i;
    if (opcode == Constants.INVOKEINTERFACE) {
        i = cw.newItfMethod(owner, name, desc);
    } else {
        i = cw.newMethod(owner, name, desc);
    }
    int argSize = i.intVal;
    if (computeMaxs) {
        // the return value corresponding to desc.
        if (argSize == 0) {
            // the above sizes have not been computed yet, so we compute them...
            argSize = getArgumentsAndReturnSizes(desc);
            // ... and we save them in order not to recompute them in the future
            i.intVal = argSize;
        }
        int size;
        if (opcode == Constants.INVOKESTATIC) {
            size = stackSize - (argSize >> 2) + (argSize & 0x03) + 1;
        } else {
            size = stackSize - (argSize >> 2) + (argSize & 0x03);
        }
        // updates current and max stack sizes
        if (size > maxStackSize) {
            maxStackSize = size;
        }
        stackSize = size;
    }
    // adds the instruction to the bytecode of the method
    if (opcode == Constants.INVOKEINTERFACE) {
        if (!computeMaxs) {
            if (argSize == 0) {
                argSize = getArgumentsAndReturnSizes(desc);
                i.intVal = argSize;
            }
        }
        code.put12(Constants.INVOKEINTERFACE, i.index).put11(argSize >> 2, 0);
    } else {
        code.put12(opcode, i.index);
    }
}