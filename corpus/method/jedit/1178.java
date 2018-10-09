/**
		Parse the BSHBlock for for the class definition and generate the class
		using ClassGenerator.
	*/
public static Class generateClassImpl(String name, Modifiers modifiers, Class[] interfaces, Class superClass, BSHBlock block, boolean isInterface, CallStack callstack, Interpreter interpreter) throws EvalError {
    // This can be eliminated with a bit more work.
    try {
        Capabilities.setAccessibility(true);
    } catch (Capabilities.Unavailable e) {
        throw new EvalError("Defining classes currently requires reflective Accessibility.", block, callstack);
    }
    NameSpace enclosingNameSpace = callstack.top();
    String packageName = enclosingNameSpace.getPackage();
    String className = enclosingNameSpace.isClass ? (enclosingNameSpace.getName() + "$" + name) : name;
    String fqClassName = packageName == null ? className : packageName + "." + className;
    BshClassManager bcm = interpreter.getClassManager();
    // Race condition here...
    bcm.definingClass(fqClassName);
    // Create the class static namespace
    NameSpace classStaticNameSpace = new NameSpace(enclosingNameSpace, className);
    classStaticNameSpace.isClass = true;
    callstack.push(classStaticNameSpace);
    // Evaluate any inner class class definitions in the block 
    // effectively recursively call this method for contained classes first
    block.evalBlock(callstack, interpreter, /*override*/
    true, ClassNodeFilter.CLASSCLASSES);
    // Generate the type for our class
    Variable[] variables = getDeclaredVariables(block, callstack, interpreter, packageName);
    DelayedEvalBshMethod[] methods = getDeclaredMethods(block, callstack, interpreter, packageName);
    ClassGeneratorUtil classGenerator = new ClassGeneratorUtil(modifiers, className, packageName, superClass, interfaces, variables, methods, classStaticNameSpace, isInterface);
    byte[] code = classGenerator.generateClass();
    // if debug, write out the class file to debugClasses directory
    String dir = System.getProperty("debugClasses");
    if (dir != null)
        try {
            FileOutputStream out = new FileOutputStream(dir + "/" + className + ".class");
            out.write(code);
            out.close();
        } catch (IOException e) {
        }
    // Define the new class in the classloader
    Class genClass = bcm.defineClass(fqClassName, code);
    // import the unq name into parent
    enclosingNameSpace.importClass(fqClassName.replace('$', '.'));
    try {
        classStaticNameSpace.setLocalVariable(ClassGeneratorUtil.BSHINIT, /*strictJava*/
        block, false);
    } catch (UtilEvalError e) {
        throw new InterpreterError("unable to init static: " + e);
    }
    // Give the static space its class static import
    // important to do this after all classes are defined
    classStaticNameSpace.setClassStatic(genClass);
    // evaluate the static portion of the block in the static space
    block.evalBlock(callstack, interpreter, /*override*/
    true, ClassNodeFilter.CLASSSTATIC);
    callstack.pop();
    if (!genClass.isInterface()) {
        // Set the static bsh This callback 
        String bshStaticFieldName = ClassGeneratorUtil.BSHSTATIC + className;
        try {
            LHS lhs = Reflect.getLHSStaticField(genClass, bshStaticFieldName);
            lhs.assign(classStaticNameSpace.getThis(interpreter), /*strict*/
            false);
        } catch (Exception e) {
            throw new InterpreterError("Error in class gen setup: " + e);
        }
    }
    bcm.doneDefiningClass(fqClassName);
    return genClass;
}