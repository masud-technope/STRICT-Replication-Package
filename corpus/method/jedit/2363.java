/**
        Invoke specified method as from outside java code, using the
        declaring interpreter and current namespace.
        The call stack will indicate that the method is being invoked from
        outside of bsh in native java code.
        Note: you must still wrap/unwrap args/return values using
        Primitive/Primitive.unwrap() for use outside of BeanShell.
        @see org.gjt.sp.jedit.bsh.Primitive
    */
public Object invokeMethod(String name, Object[] args) throws EvalError {
    // null callstack, one will be created for us
    return invokeMethod(name, args, null, /*declaringInterpreter*/
    null, null, false);
}