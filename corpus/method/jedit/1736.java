/**
   * Visits a local variable instruction. A local variable instruction is an
   * instruction that loads or stores the value of a local variable.
   *
   * @param opcode the opcode of the local variable instruction to be visited.
   *      This opcode is either ILOAD, LLOAD, FLOAD, DLOAD, ALOAD, ISTORE,
   *      LSTORE, FSTORE, DSTORE, ASTORE or RET.
   * @param var the operand of the instruction to be visited. This operand is
   *      the index of a local variable.
   */
void visitVarInsn(int opcode, int var);