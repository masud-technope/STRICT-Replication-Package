/**
		Initialize an instance of the class.
		This method is called from the generated class constructor to evaluate
		the instance initializer and scripted constructor in the instance
		namespace.
	*/
public static void initInstance(Object instance, String className, Object[] args) {
    Class[] sig = Types.getTypes(args);
    CallStack callstack = new CallStack();
    Interpreter interpreter;
    NameSpace instanceNameSpace;
    // check to see if the instance has already been initialized
    // (the case if using a this() alternate constuctor)
    This instanceThis = getClassInstanceThis(instance, className);
    // XXX clean up this conditional
    if (instanceThis == null) {
        // Create the instance 'This' namespace, set it on the object
        // instance and invoke the instance initializer
        // Get the static This reference from the proto-instance
        This classStaticThis = getClassStaticThis(instance.getClass(), className);
        interpreter = classStaticThis.declaringInterpreter;
        // Get the instance initializer block from the static This 
        BSHBlock instanceInitBlock;
        try {
            instanceInitBlock = (BSHBlock) classStaticThis.getNameSpace().getVariable(BSHINIT);
        } catch (Exception e) {
            throw new InterpreterError("unable to get instance initializer: " + e);
        }
        // Create the instance namespace
        instanceNameSpace = new NameSpace(classStaticThis.getNameSpace(), className);
        instanceNameSpace.isClass = true;
        // Set the instance This reference on the instance
        instanceThis = instanceNameSpace.getThis(interpreter);
        try {
            LHS lhs = Reflect.getLHSObjectField(instance, BSHTHIS + className);
            lhs.assign(instanceThis, /*strict*/
            false);
        } catch (Exception e) {
            throw new InterpreterError("Error in class gen setup: " + e);
        }
        // Give the instance space its object import
        instanceNameSpace.setClassInstance(instance);
        // should use try/finally here to pop ns
        callstack.push(instanceNameSpace);
        // Evaluate the initializer block
        try {
            instanceInitBlock.evalBlock(callstack, /*override*/
            interpreter, true, ClassGeneratorImpl.ClassNodeFilter.CLASSINSTANCE);
        } catch (Exception e) {
            throw new InterpreterError("Error in class initialization: " + e);
        }
        callstack.pop();
    } else {
        // The object instance has already been initialzed by another
        // constructor.  Fall through to invoke the constructor body below.
        interpreter = instanceThis.declaringInterpreter;
        instanceNameSpace = instanceThis.getNameSpace();
    }
    // invoke the constructor method from the instanceThis 
    String constructorName = getBaseName(className);
    try {
        // Find the constructor (now in the instance namespace)
        BshMethod constructor = instanceNameSpace.getMethod(constructorName, /*declaredOnly*/
        sig, true);
        // if args, we must have constructor
        if (args.length > 0 && constructor == null)
            throw new InterpreterError("Can't find constructor: " + className);
        // Evaluate the constructor
        if (constructor != null)
            constructor.invoke(args, interpreter, callstack, /*callerInfo*/
            null, /*overrideNameSpace*/
            false);
    } catch (Exception e) {
        if (e instanceof TargetError)
            e = (Exception) ((TargetError) e).getTarget();
        if (e instanceof InvocationTargetException)
            e = (Exception) ((InvocationTargetException) e).getTargetException();
        e.printStackTrace(System.err);
        throw new InterpreterError("Error in class initialization: " + e);
    }
}