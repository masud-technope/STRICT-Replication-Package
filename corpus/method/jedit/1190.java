/**
		Generate a switch with a branch for each possible alternate
		constructor.  This includes all superclass constructors and all 
		constructors of this class.  The default branch of this switch is the
		default superclass constructor.
		<p>
		This method also generates the code to call the static
		ClassGeneratorUtil
		getConstructorArgs() method which inspects the scripted constructor to
		find the alternate constructor signature (if any) and evalute the
		arguments at runtime.  The getConstructorArgs() method returns the
		actual arguments as well as the index of the constructor to call. 
	*/
void generateConstructorSwitch(int consIndex, int argsVar, int consArgsVar, CodeVisitor cv) {
    Label defaultLabel = new Label();
    Label endLabel = new Label();
    int cases = superConstructors.length + constructors.length;
    Label[] labels = new Label[cases];
    for (int i = 0; i < cases; i++) labels[i] = new Label();
    // Generate code to call ClassGeneratorUtil to get our switch index 
    // and give us args...
    // push super class name
    // use superClassName var?
    cv.visitLdcInsn(superClass.getName());
    // push class static This object
    cv.visitFieldInsn(GETSTATIC, fqClassName, BSHSTATIC + className, "Lorg/gjt/sp/jedit/bsh/This;");
    // push args
    cv.visitVarInsn(ALOAD, argsVar);
    // push this constructor index number onto stack
    cv.visitIntInsn(BIPUSH, consIndex);
    // invoke the ClassGeneratorUtil getConstructorsArgs() method
    cv.visitMethodInsn(INVOKESTATIC, "org/gjt/sp/jedit/bsh/ClassGeneratorUtil", "getConstructorArgs", "(Ljava/lang/String;Lorg/gjt/sp/jedit/bsh/This;[Ljava/lang/Object;I)" + "Lorg/gjt/sp/jedit/bsh/ClassGeneratorUtil$ConstructorArgs;");
    // store ConstructorArgs in consArgsVar
    cv.visitVarInsn(ASTORE, consArgsVar);
    // Get the ConstructorArgs selector field from ConstructorArgs
    // push ConstructorArgs 
    cv.visitVarInsn(ALOAD, consArgsVar);
    cv.visitFieldInsn(GETFIELD, "org/gjt/sp/jedit/bsh/ClassGeneratorUtil$ConstructorArgs", "selector", "I");
    // start switch
    cv.visitTableSwitchInsn(/*min*/
    0, /*max*/
    cases - 1, defaultLabel, labels);
    // generate switch body
    int index = 0;
    for (int i = 0; i < superConstructors.length; i++, index++) doSwitchBranch(index, superClassName, getTypeDescriptors(superConstructors[i].getParameterTypes()), endLabel, labels, consArgsVar, cv);
    for (int i = 0; i < constructors.length; i++, index++) doSwitchBranch(index, fqClassName, constructors[i].getParamTypeDescriptors(), endLabel, labels, consArgsVar, cv);
    // generate the default branch of switch
    cv.visitLabel(defaultLabel);
    // default branch always invokes no args super
    // push 'this' 
    cv.visitVarInsn(ALOAD, 0);
    cv.visitMethodInsn(INVOKESPECIAL, superClassName, "<init>", "()V");
    // done with switch
    cv.visitLabel(endLabel);
}