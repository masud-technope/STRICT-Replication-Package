static double doubleUnaryOperation(Double D, int kind) {
    double operand = D.doubleValue();
    switch(kind) {
        case PLUS:
            return operand;
        case MINUS:
            return -operand;
        default:
            throw new InterpreterError("bad double unaryOperation");
    }
}