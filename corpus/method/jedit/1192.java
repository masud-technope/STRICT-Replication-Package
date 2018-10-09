/**
		Generate a constructor.
	*/
void generateConstructor(int index, String[] paramTypes, int modifiers, ClassWriter cw) {
    /** offset after params of the args object [] var */
    final int argsVar = paramTypes.length + 1;
    /** offset after params of the ConstructorArgs var */
    final int consArgsVar = paramTypes.length + 2;
    String[] exceptions = null;
    String methodDescriptor = getMethodDescriptor("V", paramTypes);
    // Create this constructor method
    CodeVisitor cv = cw.visitMethod(modifiers, "<init>", methodDescriptor, exceptions);
    // Generate code to push arguments as an object array
    generateParameterReifierCode(paramTypes, /*isStatic*/
    false, cv);
    cv.visitVarInsn(ASTORE, argsVar);
    // Generate the code implementing the alternate constructor switch
    generateConstructorSwitch(index, argsVar, consArgsVar, cv);
    // Generate code to invoke the ClassGeneratorUtil initInstance() method
    // push 'this' 
    cv.visitVarInsn(ALOAD, 0);
    // Push the class/constructor name as a constant
    cv.visitLdcInsn(className);
    // Push arguments as an object array
    cv.visitVarInsn(ALOAD, argsVar);
    // invoke the initInstance() method
    cv.visitMethodInsn(INVOKESTATIC, "org/gjt/sp/jedit/bsh/ClassGeneratorUtil", "initInstance", "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)V");
    cv.visitInsn(RETURN);
    // Need to calculate this... just fudging here for now.
    cv.visitMaxs(20, 20);
}