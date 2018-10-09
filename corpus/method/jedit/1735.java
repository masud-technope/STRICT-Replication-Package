/**
   * Visits an instruction with a single int operand.
   *
   * @param opcode the opcode of the instruction to be visited. This opcode is
   *      either BIPUSH, SIPUSH or NEWARRAY.
   * @param operand the operand of the instruction to be visited.
   */
void visitIntInsn(int opcode, int operand);