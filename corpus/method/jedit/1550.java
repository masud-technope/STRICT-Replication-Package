void event(String name, Object event) {
    CallStack callstack = new CallStack(namespace);
    BshMethod method = null;
    // handleEvent gets all events
    try {
        method = namespace.getMethod("handleEvent", new Class[] { null });
    } catch (UtilEvalError /*squeltch*/
    e) {
    }
    if (method != null)
        try {
            method.invoke(new Object[] { event }, declaringInterpreter, callstack, null);
        } catch (EvalError e) {
            declaringInterpreter.error("local event hander method invocation error:" + e);
        }
    // send to specific event handler
    try {
        method = namespace.getMethod(name, new Class[] { null });
    } catch (UtilEvalError /*squeltch*/
    e) {
    }
    if (method != null)
        try {
            method.invoke(new Object[] { event }, declaringInterpreter, callstack, null);
        } catch (EvalError e) {
            declaringInterpreter.error("local event hander method invocation error:" + e);
        }
}