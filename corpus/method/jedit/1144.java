private Object unaryOperation(Object op, int kind) throws UtilEvalError {
    if (op instanceof Boolean || op instanceof Character || op instanceof Number)
        return primitiveWrapperUnaryOperation(op, kind);
    if (!(op instanceof Primitive))
        throw new UtilEvalError("Unary operation " + tokenImage[kind] + " inappropriate for object");
    return Primitive.unaryOperation((Primitive) op, kind);
}