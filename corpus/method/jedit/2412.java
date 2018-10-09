public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    try {
        return invokeImpl(proxy, method, args);
    } catch (TargetError te) {
        throw te.getTarget();
    } catch (EvalError ee) {
        if (Interpreter.DEBUG)
            Interpreter.debug("EvalError in scripted interface: " + XThis.this.toString() + ": " + ee);
        throw ee;
    }
}