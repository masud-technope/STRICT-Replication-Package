/**
		Evaluate the arguments (if any) for the constructor specified by
		the constructor index.  Return the ConstructorArgs object which
		contains the actual arguments to the alternate constructor and also the
		index of that constructor for the constructor switch.

		@param consArgs the arguments to the constructor.  These are necessary in
		the evaluation of the alt constructor args.  e.g. Foo(a) { super(a); }
		@return the ConstructorArgs object containing a constructor selector
			and evaluated arguments for the alternate constructor
	*/
public static ConstructorArgs getConstructorArgs(String superClassName, This classStaticThis, Object[] consArgs, int index) {
    DelayedEvalBshMethod[] constructors;
    try {
        constructors = (DelayedEvalBshMethod[]) classStaticThis.getNameSpace().getVariable(BSHCONSTRUCTORS);
    } catch (Exception e) {
        throw new InterpreterError("unable to get instance initializer: " + e);
    }
    if (// auto-gen default constructor
    index == DEFAULTCONSTRUCTOR)
        // use default super constructor
        return ConstructorArgs.DEFAULT;
    DelayedEvalBshMethod constructor = constructors[index];
    if (constructor.methodBody.jjtGetNumChildren() == 0)
        // use default super constructor
        return ConstructorArgs.DEFAULT;
    // Determine if the constructor calls this() or super()
    String altConstructor = null;
    BSHArguments argsNode = null;
    SimpleNode firstStatement = (SimpleNode) constructor.methodBody.jjtGetChild(0);
    if (firstStatement instanceof BSHPrimaryExpression)
        firstStatement = (SimpleNode) firstStatement.jjtGetChild(0);
    if (firstStatement instanceof BSHMethodInvocation) {
        BSHMethodInvocation methodNode = (BSHMethodInvocation) firstStatement;
        BSHAmbiguousName methodName = methodNode.getNameNode();
        if (methodName.text.equals("super") || methodName.text.equals("this")) {
            altConstructor = methodName.text;
            argsNode = methodNode.getArgsNode();
        }
    }
    if (altConstructor == null)
        // use default super constructor
        return ConstructorArgs.DEFAULT;
    // Make a tmp namespace to hold the original constructor args for
    // use in eval of the parameters node
    NameSpace consArgsNameSpace = new NameSpace(classStaticThis.getNameSpace(), "consArgs");
    String[] consArgNames = constructor.getParameterNames();
    Class[] consArgTypes = constructor.getParameterTypes();
    for (int i = 0; i < consArgs.length; i++) {
        try {
            consArgsNameSpace.setTypedVariable(consArgNames[i], consArgTypes[i], consArgs[i], /*modifiers*/
            null);
        } catch (UtilEvalError e) {
            throw new InterpreterError("err setting local cons arg:" + e);
        }
    }
    // evaluate the args
    CallStack callstack = new CallStack();
    callstack.push(consArgsNameSpace);
    Object[] args = null;
    Interpreter interpreter = classStaticThis.declaringInterpreter;
    try {
        args = argsNode.getArguments(callstack, interpreter);
    } catch (EvalError e) {
        throw new InterpreterError("Error evaluating constructor args: " + e);
    }
    Class[] argTypes = Types.getTypes(args);
    args = Primitive.unwrap(args);
    Class superClass = interpreter.getClassManager().classForName(superClassName);
    if (superClass == null)
        throw new InterpreterError("can't find superclass: " + superClassName);
    Constructor[] superCons = superClass.getDeclaredConstructors();
    // find the matching super() constructor for the args
    if (altConstructor.equals("super")) {
        int i = Reflect.findMostSpecificConstructorIndex(argTypes, superCons);
        if (i == -1)
            throw new InterpreterError("can't find constructor for args!");
        return new ConstructorArgs(i, args);
    }
    // find the matching this() constructor for the args
    Class[][] candidates = new Class[constructors.length][];
    for (int i = 0; i < candidates.length; i++) candidates[i] = constructors[i].getParameterTypes();
    int i = Reflect.findMostSpecificSignature(argTypes, candidates);
    if (i == -1)
        throw new InterpreterError("can't find constructor for args 2!");
    // this() constructors come after super constructors in the table
    int selector = i + superCons.length;
    int ourSelector = index + superCons.length;
    // Are we choosing ourselves recursively through a this() reference?
    if (selector == ourSelector)
        throw new InterpreterError("Recusive constructor call.");
    return new ConstructorArgs(selector, args);
}