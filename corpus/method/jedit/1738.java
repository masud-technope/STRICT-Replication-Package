/**
   * Visits a field instruction. A field instruction is an instruction that
   * loads or stores the value of a field of an object.
   *
   * @param opcode the opcode of the type instruction to be visited. This opcode
   *      is either GETSTATIC, PUTSTATIC, GETFIELD or PUTFIELD.
   * @param owner the internal name of the field's owner class (see {@link
   *      Type#getInternalName getInternalName}).
   * @param name the field's name.
   * @param desc the field's descriptor (see {@link Type Type}).
   */
void visitFieldInsn(int opcode, String owner, String name, String desc);