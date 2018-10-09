/**
   * Returns a JVM instruction opcode adapted to this Java type.
   *
   * @param opcode a JVM instruction opcode. This opcode must be one of ILOAD,
   *      ISTORE, IALOAD, IASTORE, IADD, ISUB, IMUL, IDIV, IREM, INEG, ISHL,
   *      ISHR, IUSHR, IAND, IOR, IXOR and IRETURN.
   * @return an opcode that is similar to the given opcode, but adapted to this
   *      Java type. For example, if this type is <tt>float</tt> and
   *      <tt>opcode</tt> is IRETURN, this method returns FRETURN.
   */
public int getOpcode(final int opcode) {
    if (opcode == Constants.IALOAD || opcode == Constants.IASTORE) {
        switch(sort) {
            case VOID:
                return opcode + 5;
            case BOOLEAN:
            case BYTE:
                return opcode + 6;
            case CHAR:
                return opcode + 7;
            case SHORT:
                return opcode + 8;
            case INT:
                return opcode;
            case FLOAT:
                return opcode + 2;
            case LONG:
                return opcode + 1;
            case DOUBLE:
                return opcode + 3;
            //case OBJECT:
            default:
                return opcode + 4;
        }
    } else {
        switch(sort) {
            case VOID:
                return opcode + 5;
            case BOOLEAN:
            case CHAR:
            case BYTE:
            case SHORT:
            case INT:
                return opcode;
            case FLOAT:
                return opcode + 2;
            case LONG:
                return opcode + 1;
            case DOUBLE:
                return opcode + 3;
            //case OBJECT:
            default:
                return opcode + 4;
        }
    }
}