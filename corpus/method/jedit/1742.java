// -------------------------------------------------------------------------
// Special instructions
// -------------------------------------------------------------------------
/**
   * Visits a LDC instruction.
   *
   * @param cst the constant to be loaded on the stack. This parameter must be
   *      a non null {@link java.lang.Integer Integer}, a {@link java.lang.Float
   *      Float}, a {@link java.lang.Long Long}, a {@link java.lang.Double
   *      Double} or a {@link String String}.
   */
void visitLdcInsn(Object cst);