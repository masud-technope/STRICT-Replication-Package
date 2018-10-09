// -------------------------------------------------------------------------
// Debug information
// -------------------------------------------------------------------------
/**
   * Visits a local variable declaration.
   *
   * @param name the name of a local variable.
   * @param desc the type descriptor of this local variable.
   * @param start the first instruction corresponding to the scope of this
   *      local variable (inclusive).
   * @param end the last instruction corresponding to the scope of this
   *      local variable (exclusive).
   * @param index the local variable's index.
   * @throws IllegalArgumentException if one of the labels has not already been
   *      visited by this visitor (by the {@link #visitLabel visitLabel}
   *      method).
   */
void visitLocalVariable(String name, String desc, Label start, Label end, int index);