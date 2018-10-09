static int intUnaryOperation(Integer I, int kind) {
    int operand = I.intValue();
    switch(kind) {
        case PLUS:
            return operand;
        case MINUS:
            return -operand;
        case TILDE:
            return ~operand;
        case INCR:
            return operand + 1;
        case DECR:
            return operand - 1;
        default:
            throw new InterpreterError("bad integer unaryOperation");
    }
}