private Object objectAllocation(BSHAmbiguousName nameNode, BSHArguments argumentsNode, CallStack callstack, Interpreter interpreter) throws EvalError {
    NameSpace namespace = callstack.top();
    Object[] args = argumentsNode.getArguments(callstack, interpreter);
    if (args == null)
        throw new EvalError("Null args in new.", this, callstack);
    // Look for scripted class object
    Object obj = nameNode.toObject(callstack, interpreter, /* force class*/
    false);
    // Try regular class
    obj = nameNode.toObject(callstack, interpreter, /*force class*/
    true);
    Class type = null;
    if (obj instanceof ClassIdentifier)
        type = ((ClassIdentifier) obj).getTargetClass();
    else
        throw new EvalError("Unknown class: " + nameNode.text, this, callstack);
    // Is an inner class style object allocation
    boolean hasBody = jjtGetNumChildren() > 2;
    if (hasBody) {
        BSHBlock body = (BSHBlock) jjtGetChild(2);
        if (type.isInterface())
            return constructWithInterfaceBody(type, args, body, callstack, interpreter);
        else
            return constructWithClassBody(type, args, body, callstack, interpreter);
    } else
        return constructObject(type, args, callstack);
}