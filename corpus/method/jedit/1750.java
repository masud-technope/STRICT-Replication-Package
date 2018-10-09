/**
   * Visits a line number declaration.
   *
   * @param line a line number. This number refers to the source file
   *      from which the class was compiled.
   * @param start the first instruction corresponding to this line number.
   * @throws IllegalArgumentException if <tt>start</tt> has not already been
   *      visited by this visitor (by the {@link #visitLabel visitLabel}
   *      method).
   */
void visitLineNumber(int line, Label start);