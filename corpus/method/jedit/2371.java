/**
        getThis() is a factory for bsh.This type references.  The capabilities
        of ".this" references in bsh are version dependent up until jdk1.3.
        The version dependence was to support different default interface
        implementations.  i.e. different sets of listener interfaces which
        scripted objects were capable of implementing.  In jdk1.3 the
        reflection proxy mechanism was introduced which allowed us to
        implement arbitrary interfaces.  This is fantastic.

        A This object is a thin layer over a namespace, comprising a bsh object
        context.  We create it here only if needed for the namespace.

        Note: this method could be considered slow because of the way it
        dynamically factories objects.  However I've also done tests where
        I hard-code the factory to return JThis and see no change in the
        rough test suite time.  This references are also cached in NameSpace.
    */
static This getThis(NameSpace namespace, Interpreter declaringInterpreter) {
    try {
        Class c;
        if (Capabilities.canGenerateInterfaces())
            c = Class.forName("org.gjt.sp.jedit.bsh.XThis");
        else if (Capabilities.haveSwing())
            c = Class.forName("org.gjt.sp.jedit.bsh.JThis");
        else
            return new This(namespace, declaringInterpreter);
        return (This) Reflect.constructObject(c, new Object[] { namespace, declaringInterpreter });
    } catch (Exception e) {
        throw new InterpreterError("internal error 1 in This: " + e);
    }
}