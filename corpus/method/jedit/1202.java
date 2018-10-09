/**
		@param packageName e.g. "com.foo.bar"
	*/
public  ClassGeneratorUtil(Modifiers classModifiers, String className, String packageName, Class superClass, Class[] interfaces, Variable[] vars, DelayedEvalBshMethod[] bshmethods, NameSpace classStaticNameSpace, boolean isInterface) {
    this.classModifiers = classModifiers;
    this.className = className;
    if (packageName != null)
        this.fqClassName = packageName.replace('.', '/') + "/" + className;
    else
        this.fqClassName = className;
    if (superClass == null)
        superClass = Object.class;
    this.superClass = superClass;
    this.superClassName = Type.getInternalName(superClass);
    if (interfaces == null)
        interfaces = new Class[0];
    this.interfaces = interfaces;
    this.vars = vars;
    this.classStaticNameSpace = classStaticNameSpace;
    this.superConstructors = superClass.getDeclaredConstructors();
    // Split the methods into constructors and regular method lists
    List consl = new ArrayList();
    List methodsl = new ArrayList();
    // for inner classes
    String classBaseName = getBaseName(className);
    for (int i = 0; i < bshmethods.length; i++) if (bshmethods[i].getName().equals(classBaseName))
        consl.add(bshmethods[i]);
    else
        methodsl.add(bshmethods[i]);
    this.constructors = (DelayedEvalBshMethod[]) consl.toArray(new DelayedEvalBshMethod[0]);
    this.methods = (DelayedEvalBshMethod[]) methodsl.toArray(new DelayedEvalBshMethod[0]);
    try {
        classStaticNameSpace.setLocalVariable(BSHCONSTRUCTORS, constructors, /*strict*/
        false);
    } catch (UtilEvalError e) {
        throw new InterpreterError("can't set cons var");
    }
    this.isInterface = isInterface;
}