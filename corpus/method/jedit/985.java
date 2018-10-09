private void throwTypeError(Class baseType, Object initializer, int argNum, CallStack callstack) throws EvalError {
    String rhsType;
    if (initializer instanceof Primitive)
        rhsType = ((Primitive) initializer).getType().getName();
    else
        rhsType = Reflect.normalizeClassName(initializer.getClass());
    throw new EvalError("Incompatible type: " + rhsType + " in initializer of array type: " + baseType + " at position: " + argNum, this, callstack);
}