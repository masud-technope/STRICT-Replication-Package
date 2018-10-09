// -------------------------------------------------------------------------
// Exceptions table entries, max stack size and max locals
// -------------------------------------------------------------------------
/**
   * Visits a try catch block.
   *
   * @param start beginning of the exception handler's scope (inclusive).
   * @param end end of the exception handler's scope (exclusive).
   * @param handler beginning of the exception handler's code.
   * @param type internal name of the type of exceptions handled by the handler,
   *      or <tt>null</tt> to catch any exceptions (for "finally" blocks).
   * @throws IllegalArgumentException if one of the labels has not already been
   *      visited by this visitor (by the {@link #visitLabel visitLabel}
   *      method).
   */
void visitTryCatchBlock(Label start, Label end, Label handler, String type);