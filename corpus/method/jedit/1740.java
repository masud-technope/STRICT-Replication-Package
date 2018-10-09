/**
   * Visits a jump instruction. A jump instruction is an instruction that may
   * jump to another instruction.
   *
   * @param opcode the opcode of the type instruction to be visited. This opcode
   *      is either IFEQ, IFNE, IFLT, IFGE, IFGT, IFLE, IF_ICMPEQ, IF_ICMPNE,
   *      IF_ICMPLT, IF_ICMPGE, IF_ICMPGT, IF_ICMPLE, IF_ACMPEQ, IF_ACMPNE,
   *      GOTO, JSR, IFNULL or IFNONNULL.
   * @param label the operand of the instruction to be visited. This operand is
   *      a label that designates the instruction to which the jump instruction
   *      may jump.
   */
void visitJumpInsn(int opcode, Label label);