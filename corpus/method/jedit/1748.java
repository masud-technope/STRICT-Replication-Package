/**
   * Visits a MULTIANEWARRAY instruction.
   *
   * @param desc an array type descriptor (see {@link Type Type}).
   * @param dims number of dimensions of the array to allocate.
   */
void visitMultiANewArrayInsn(String desc, int dims);