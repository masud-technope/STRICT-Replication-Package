/**
        Invoke a method in this namespace with the specified args,
        interpreter reference, callstack, and caller info.
        <p>

        Note: If you use this method outside of the bsh package and wish to
        use variables with primitive values you will have to wrap them using
        bsh.Primitive.  Consider using This getInterface() to make a true Java
        interface for invoking your scripted methods.
        <p>

        This method also implements the default object protocol of toString(),
        hashCode() and equals() and the invoke() meta-method handling as a
        last resort.
        <p>

        Note: The invoke() meta-method will not catch the Object protocol
        methods (toString(), hashCode()...).  If you want to override them you
        have to script them directly.
        <p>

        @see org.gjt.sp.jedit.bsh.This#invokeMethod(String methodName, Object [] args, Interpreter interpreter, CallStack callstack, SimpleNode callerInfo, boolean declaredOnly ) invokeMethod
        @param callstack if callStack is null a new CallStack will be created and
            initialized with this namespace.
        @param declaredOnly if true then only methods declared directly in the
            namespace will be visible - no inherited or imported methods will
            be visible.
        @see org.gjt.sp.jedit.bsh.Primitive Primitive
    */
/*
        invokeMethod() here is generally used by outside code to callback
        into the bsh interpreter. e.g. when we are acting as an interface
        for a scripted listener, etc.  In this case there is no real call stack
        so we make a default one starting with the special JAVACODE namespace
        and our namespace as the next.
    */
public Object invokeMethod(String methodName, Object[] args, Interpreter interpreter, CallStack callstack, SimpleNode callerInfo, boolean declaredOnly) throws EvalError {
    /*
            Wrap nulls.
            This is a bit of a cludge to address a deficiency in the class
            generator whereby it does not wrap nulls on method delegate.  See
            Class Generator.java.  If we fix that then we can remove this.
            (just have to generate the code there.)
        */
    if (args != null) {
        Object[] oa = new Object[args.length];
        for (int i = 0; i < args.length; i++) oa[i] = (args[i] == null ? Primitive.NULL : args[i]);
        args = oa;
    }
    if (interpreter == null)
        interpreter = declaringInterpreter;
    if (callstack == null)
        callstack = new CallStack(namespace);
    if (callerInfo == null)
        callerInfo = SimpleNode.JAVACODE;
    // Find the bsh method
    Class[] types = Types.getTypes(args);
    BshMethod bshMethod = null;
    try {
        bshMethod = namespace.getMethod(methodName, types, declaredOnly);
    } catch (UtilEvalError e) {
    }
    if (bshMethod != null)
        return bshMethod.invoke(args, interpreter, callstack, callerInfo);
    // a default toString() that shows the interfaces we implement
    if (methodName.equals("toString"))
        return toString();
    // a default hashCode()
    if (methodName.equals("hashCode"))
        return Integer.valueOf(this.hashCode());
    // a default equals() testing for equality with the This reference
    if (methodName.equals("equals")) {
        Object obj = args[0];
        return Boolean.valueOf(this == obj);
    }
    // is that ok?
    try {
        bshMethod = namespace.getMethod("invoke", new Class[] { null, null });
    } catch (UtilEvalError e) {
    }
    // Call script "invoke( String methodName, Object [] args );
    if (bshMethod != null)
        return bshMethod.invoke(new Object[] { methodName, args }, interpreter, callstack, callerInfo);
    throw new EvalError("Method " + StringUtil.methodString(methodName, types) + " not found in bsh scripted object: " + namespace.getName(), callerInfo, callstack);
}