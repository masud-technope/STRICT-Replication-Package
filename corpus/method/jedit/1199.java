/**
		Generate the class bytecode for this class.
	*/
public byte[] generateClass() {
    // Force the class public for now...
    int classMods = getASMModifiers(classModifiers) | ACC_PUBLIC;
    if (isInterface)
        classMods |= ACC_INTERFACE;
    String[] interfaceNames = new String[interfaces.length];
    for (int i = 0; i < interfaces.length; i++) interfaceNames[i] = Type.getInternalName(interfaces[i]);
    String sourceFile = "BeanShell Generated via ASM (www.objectweb.org)";
    ClassWriter cw = new ClassWriter(false);
    cw.visit(classMods, fqClassName, superClassName, interfaceNames, sourceFile);
    if (!isInterface) {
        // Generate the bsh instance 'This' reference holder field
        generateField(BSHTHIS + className, "Lorg/gjt/sp/jedit/bsh/This;", ACC_PUBLIC, cw);
        // Generate the static bsh static reference holder field
        generateField(BSHSTATIC + className, "Lorg/gjt/sp/jedit/bsh/This;", ACC_PUBLIC + ACC_STATIC, cw);
    }
    // Generate the fields
    for (int i = 0; i < vars.length; i++) {
        String type = vars[i].getTypeDescriptor();
        // Note: loose types aren't currently parsed anyway...
        if (vars[i].hasModifier("private") || type == null)
            continue;
        int modifiers;
        if (isInterface)
            modifiers = ACC_PUBLIC | ACC_STATIC | ACC_FINAL;
        else
            modifiers = getASMModifiers(vars[i].getModifiers());
        generateField(vars[i].getName(), type, modifiers, cw);
    }
    // Generate the constructors
    boolean hasConstructor = false;
    for (int i = 0; i < constructors.length; i++) {
        // Don't generate private constructors
        if (constructors[i].hasModifier("private"))
            continue;
        int modifiers = getASMModifiers(constructors[i].getModifiers());
        generateConstructor(i, constructors[i].getParamTypeDescriptors(), modifiers, cw);
        hasConstructor = true;
    }
    // If no other constructors, generate a default constructor
    if (!isInterface && !hasConstructor)
        generateConstructor(DEFAULTCONSTRUCTOR/*index*/
        , new String[0], ACC_PUBLIC, cw);
    // Generate the delegate methods
    for (int i = 0; i < methods.length; i++) {
        String returnType = methods[i].getReturnTypeDescriptor();
        // Don't generate private /*or loosely return typed */ methods
        if (methods[i].hasModifier("private"))
            /*|| returnType == null*/
            continue;
        int modifiers = getASMModifiers(methods[i].getModifiers());
        if (isInterface)
            modifiers |= (ACC_PUBLIC | ACC_ABSTRACT);
        generateMethod(className, fqClassName, methods[i].getName(), returnType, methods[i].getParamTypeDescriptors(), modifiers, cw);
        boolean isStatic = (modifiers & ACC_STATIC) > 0;
        boolean overridden = classContainsMethod(superClass, methods[i].getName(), methods[i].getParamTypeDescriptors());
        if (!isStatic && overridden)
            generateSuperDelegateMethod(superClassName, methods[i].getName(), returnType, methods[i].getParamTypeDescriptors(), modifiers, cw);
    }
    return cw.toByteArray();
}