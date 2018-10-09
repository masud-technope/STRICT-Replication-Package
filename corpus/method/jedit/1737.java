/**
   * Visits a type instruction. A type instruction is an instruction that
   * takes a type descriptor as parameter.
   *
   * @param opcode the opcode of the type instruction to be visited. This opcode
   *      is either NEW, ANEWARRAY, CHECKCAST or INSTANCEOF.
   * @param desc the operand of the instruction to be visited. This operand is
   *      must be a fully qualified class name in internal form, or the type
   *      descriptor of an array type (see {@link Type Type}).
   */
void visitTypeInsn(int opcode, String desc);