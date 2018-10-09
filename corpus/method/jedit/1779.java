/**
   * Returns the current size of the bytecode of this method. This size just
   * includes the size of the bytecode instructions: it does not include the
   * size of the Exceptions, LocalVariableTable, LineNumberTable, Synthetic
   * and Deprecated attributes, if present.
   *
   * @return the current size of the bytecode of this method.
   */
protected int getCodeSize() {
    return code.length;
}