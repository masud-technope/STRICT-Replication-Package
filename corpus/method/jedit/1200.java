/**
		Generate a delegate method - static or instance.
		The generated code packs the method arguments into an object array
		(wrapping primitive types in bsh.Primitive), invokes the static or
		instance namespace invokeMethod() method, and then unwraps / returns
		the result.
	*/
static void generateMethod(String className, String fqClassName, String methodName, String returnType, String[] paramTypes, int modifiers, ClassWriter cw) {
    String[] exceptions = null;
    boolean isStatic = (modifiers & ACC_STATIC) != 0;
    if (// map loose return type to Object
    returnType == null)
        returnType = OBJECT;
    String methodDescriptor = getMethodDescriptor(returnType, paramTypes);
    // Generate method body
    CodeVisitor cv = cw.visitMethod(modifiers, methodName, methodDescriptor, exceptions);
    if ((modifiers & ACC_ABSTRACT) != 0)
        return;
    // Generate code to push the BSHTHIS or BSHSTATIC field 
    if (isStatic) {
        cv.visitFieldInsn(GETSTATIC, fqClassName, BSHSTATIC + className, "Lorg/gjt/sp/jedit/bsh/This;");
    } else {
        // Push 'this'
        cv.visitVarInsn(ALOAD, 0);
        // Get the instance field
        cv.visitFieldInsn(GETFIELD, fqClassName, BSHTHIS + className, "Lorg/gjt/sp/jedit/bsh/This;");
    }
    // Push the name of the method as a constant
    cv.visitLdcInsn(methodName);
    // Generate code to push arguments as an object array
    generateParameterReifierCode(paramTypes, isStatic, cv);
    // Push nulls for various args of invokeMethod
    // interpreter
    cv.visitInsn(ACONST_NULL);
    // callstack
    cv.visitInsn(ACONST_NULL);
    // callerinfo
    cv.visitInsn(ACONST_NULL);
    // Push the boolean constant 'true' (for declaredOnly)
    cv.visitInsn(ICONST_1);
    // Invoke the method This.invokeMethod( name, Class [] sig, boolean )
    cv.visitMethodInsn(INVOKEVIRTUAL, "org/gjt/sp/jedit/bsh/This", "invokeMethod", Type.getMethodDescriptor(Type.getType(Object.class), new Type[] { Type.getType(String.class), Type.getType(Object[].class), Type.getType(Interpreter.class), Type.getType(CallStack.class), Type.getType(SimpleNode.class), Type.getType(Boolean.TYPE) }));
    // Generate code to unwrap bsh Primitive types
    cv.visitMethodInsn(INVOKESTATIC, "org/gjt/sp/jedit/bsh/Primitive", "unwrap", "(Ljava/lang/Object;)Ljava/lang/Object;");
    // Generate code to return the value
    generateReturnCode(returnType, cv);
    // Need to calculate this... just fudging here for now.
    cv.visitMaxs(20, 20);
}