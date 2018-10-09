/**
		Invoke the method identified by this name.
		Performs caching of method resolution using SignatureKey.
		<p>

        Name contains a wholely unqualfied messy name; resolve it to 
		( object | static prefix ) + method name and invoke.
		<p>

        The interpreter is necessary to support 'this.interpreter' references
		in the called code. (e.g. debug());
		<p>

		<pre>
        Some cases:

            // dynamic
            local();
            myVariable.foo();
            myVariable.bar.blah.foo();
            // static
            java.lang.Integer.getInteger("foo");
		</pre>
    */
public Object invokeMethod(Interpreter interpreter, Object[] args, CallStack callstack, SimpleNode callerInfo) throws UtilEvalError, EvalError, ReflectError, InvocationTargetException {
    String methodName = Name.suffix(value, 1);
    BshClassManager bcm = interpreter.getClassManager();
    NameSpace namespace = callstack.top();
    // Note: maybe factor this out with path below... clean up.
    if (classOfStaticMethod != null) {
        return Reflect.invokeStaticMethod(bcm, classOfStaticMethod, methodName, args);
    }
    if (!Name.isCompound(value))
        return invokeLocalMethod(interpreter, args, callstack, callerInfo);
    // Note: if we want methods declared inside blocks to be accessible via
    // this.methodname() inside the block we could handle it here as a
    // special case.  See also resolveThisFieldReference() special handling
    // for BlockNameSpace case.  They currently work via the direct name
    // e.g. methodName().
    String prefix = Name.prefix(value);
    // Superclass method invocation? (e.g. super.foo())
    if (prefix.equals("super") && Name.countParts(value) == 2) {
        // Allow getThis() to work through block namespaces first
        This ths = namespace.getThis(interpreter);
        NameSpace thisNameSpace = ths.getNameSpace();
        NameSpace classNameSpace = getClassNameSpace(thisNameSpace);
        if (classNameSpace != null) {
            Object instance = classNameSpace.getClassInstance();
            return ClassGenerator.getClassGenerator().invokeSuperclassMethod(bcm, instance, methodName, args);
        }
    }
    // Find target object or class identifier
    Name targetName = namespace.getNameResolver(prefix);
    Object obj = targetName.toObject(callstack, interpreter);
    if (obj == Primitive.VOID)
        throw new UtilEvalError("Attempt to resolve method: " + methodName + "() on undefined variable or class name: " + targetName);
    // if we've got an object, resolve the method
    if (!(obj instanceof ClassIdentifier)) {
        if (obj instanceof Primitive) {
            if (obj == Primitive.NULL)
                throw new UtilTargetError(new NullPointerException("Null Pointer in Method Invocation"));
            // but the hole is useful right now.
            if (Interpreter.DEBUG)
                interpreter.debug("Attempt to access method on primitive..." + " allowing bsh.Primitive to peek through for debugging");
        }
        // found an object and it's not an undefined variable
        return Reflect.invokeObjectMethod(obj, methodName, args, interpreter, callstack, callerInfo);
    }
    // try static method
    if (Interpreter.DEBUG)
        Interpreter.debug("invokeMethod: trying static - " + targetName);
    Class clas = ((ClassIdentifier) obj).getTargetClass();
    // cache the fact that this is a static method invocation on this class
    classOfStaticMethod = clas;
    if (clas != null)
        return Reflect.invokeStaticMethod(bcm, clas, methodName, args);
    // return null; ???
    throw new UtilEvalError("invokeMethod: unknown target: " + targetName);
}