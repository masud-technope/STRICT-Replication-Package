/**
        Invoke a method in this namespace with the specified args and
        interpreter reference.  No caller information or call stack is
        required.  The method will appear as if called externally from Java.
        <p>

        @see org.gjt.sp.jedit.bsh.This#invokeMethod(String methodName, Object [] args, Interpreter interpreter,	CallStack callstack, SimpleNode callerInfo, boolean ) invokeMethod
    */
public Object invokeMethod(String methodName, Object[] args, Interpreter interpreter) throws EvalError {
    return invokeMethod(methodName, args, interpreter, null, null);
}