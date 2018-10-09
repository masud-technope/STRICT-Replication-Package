/**
   * Visits a method instruction. A method instruction is an instruction that
   * invokes a method.
   *
   * @param opcode the opcode of the type instruction to be visited. This opcode
   *      is either INVOKEVIRTUAL, INVOKESPECIAL, INVOKESTATIC or
   *      INVOKEINTERFACE.
   * @param owner the internal name of the method's owner class (see {@link
   *      Type#getInternalName getInternalName}).
   * @param name the method's name.
   * @param desc the method's descriptor (see {@link Type Type}).
   */
void visitMethodInsn(int opcode, String owner, String name, String desc);