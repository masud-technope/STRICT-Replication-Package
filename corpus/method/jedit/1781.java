/**
   * Returns the current bytecode of this method. This bytecode only contains
   * the instructions: it does not include the Exceptions, LocalVariableTable,
   * LineNumberTable, Synthetic and Deprecated attributes, if present.
   *
   * @return the current bytecode of this method. The bytecode is contained
   *      between the index 0 (inclusive) and the index {@link #getCodeSize
   *      getCodeSize} (exclusive).
   */
protected byte[] getCode() {
    return code.data;
}