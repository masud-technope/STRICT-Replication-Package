private Object constructWithInterfaceBody(Class type, Object[] args, BSHBlock body, CallStack callstack, Interpreter interpreter) throws EvalError {
    NameSpace namespace = callstack.top();
    NameSpace local = new NameSpace(namespace, "AnonymousBlock");
    callstack.push(local);
    body.eval(callstack, interpreter, /*overrideNamespace*/
    true);
    callstack.pop();
    // statical import fields from the interface so that code inside
    // can refer to the fields directly (e.g. HEIGHT)
    local.importStatic(type);
    try {
        return local.getThis(interpreter).getInterface(type);
    } catch (UtilEvalError e) {
        throw e.toEvalError(this, callstack);
    }
}