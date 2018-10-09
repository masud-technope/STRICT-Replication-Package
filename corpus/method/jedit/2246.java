static float floatUnaryOperation(Float F, int kind) {
    float operand = F.floatValue();
    switch(kind) {
        case PLUS:
            return operand;
        case MINUS:
            return -operand;
        default:
            throw new InterpreterError("bad float unaryOperation");
    }
}