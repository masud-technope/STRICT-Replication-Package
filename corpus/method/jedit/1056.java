public static boolean evaluateCondition(SimpleNode condExp, CallStack callstack, Interpreter interpreter) throws EvalError {
    Object obj = condExp.eval(callstack, interpreter);
    if (obj instanceof Primitive) {
        if (obj == Primitive.VOID)
            throw new EvalError("Condition evaluates to void type", condExp, callstack);
        obj = ((Primitive) obj).getValue();
    }
    if (obj instanceof Boolean)
        return ((Boolean) obj).booleanValue();
    else
        throw new EvalError("Condition must evaluate to a Boolean or boolean.", condExp, callstack);
}