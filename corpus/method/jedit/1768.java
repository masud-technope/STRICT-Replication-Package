// --------------------------------------------------------------------------
// Utility methods: dump bytecode array
// --------------------------------------------------------------------------
/**
   * Returns the size of the bytecode of this method.
   *
   * @return the size of the bytecode of this method.
   */
final int getSize() {
    if (resize) {
        // replaces the temporary jump opcodes introduced by Label.resolve.
        resizeInstructions(new int[0], new int[0], 0);
    }
    int size = 8;
    if (code.length > 0) {
        cw.newUTF8("Code");
        size += 18 + code.length + 8 * catchCount;
        if (localVar != null) {
            size += 8 + localVar.length;
        }
        if (lineNumber != null) {
            size += 8 + lineNumber.length;
        }
    }
    if (exceptionCount > 0) {
        cw.newUTF8("Exceptions");
        size += 8 + 2 * exceptionCount;
    }
    if ((access & Constants.ACC_SYNTHETIC) != 0) {
        cw.newUTF8("Synthetic");
        size += 6;
    }
    if ((access & Constants.ACC_DEPRECATED) != 0) {
        cw.newUTF8("Deprecated");
        size += 6;
    }
    return size;
}