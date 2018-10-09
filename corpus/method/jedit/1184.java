/**
		Generate a superclass method delegate accessor method.
		These methods are specially named methods which allow access to
		overridden methods of the superclass (which the Java reflection API
		normally does not allow).
	*/
// Maybe combine this with generateMethod()
static void generateSuperDelegateMethod(String superClassName, String methodName, String returnType, String[] paramTypes, int modifiers, ClassWriter cw) {
    String[] exceptions = null;
    if (// map loose return to Object
    returnType == null)
        returnType = OBJECT;
    String methodDescriptor = getMethodDescriptor(returnType, paramTypes);
    // Add method body
    CodeVisitor cv = cw.visitMethod(modifiers, "_bshSuper" + methodName, methodDescriptor, exceptions);
    cv.visitVarInsn(ALOAD, 0);
    // Push vars
    int localVarIndex = 1;
    for (int i = 0; i < paramTypes.length; ++i) {
        if (isPrimitive(paramTypes[i]))
            cv.visitVarInsn(ILOAD, localVarIndex);
        else
            cv.visitVarInsn(ALOAD, localVarIndex);
        localVarIndex += ((paramTypes[i].equals("D") || paramTypes[i].equals("J")) ? 2 : 1);
    }
    cv.visitMethodInsn(INVOKESPECIAL, superClassName, methodName, methodDescriptor);
    generatePlainReturnCode(returnType, cv);
    // Need to calculate this... just fudging here for now.
    cv.visitMaxs(20, 20);
}