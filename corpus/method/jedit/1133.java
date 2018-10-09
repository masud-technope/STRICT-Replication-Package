/**
		 Returns a class descriptor for this type.
		 If the type is an ambiguous name (object type) evaluation is 
		 attempted through the namespace in order to resolve imports.
		 If it is not found and the name is non-compound we assume the default
		 package for the name.
	*/
public String getTypeDescriptor(CallStack callstack, Interpreter interpreter, String defaultPackage) {
    // return cached type if available
    if (descriptor != null)
        return descriptor;
    String descriptor;
    //  first node will either be PrimitiveType or AmbiguousName
    SimpleNode node = getTypeNode();
    if (node instanceof BSHPrimitiveType)
        descriptor = getTypeDescriptor(((BSHPrimitiveType) node).type);
    else {
        String clasName = ((BSHAmbiguousName) node).text;
        BshClassManager bcm = interpreter.getClassManager();
        // Note: incorrect here - we are using the hack in bsh class
        // manager that allows lookup by base name.  We need to eliminate
        // this limitation by working through imports.  See notes in class
        // manager.
        String definingClass = bcm.getClassBeingDefined(clasName);
        Class clas = null;
        if (definingClass == null) {
            try {
                clas = ((BSHAmbiguousName) node).toClass(callstack, interpreter);
            } catch (EvalError e) {
            }
        } else
            clasName = definingClass;
        if (clas != null) {
            //System.out.println("found clas: "+clas);
            descriptor = getTypeDescriptor(clas);
        } else {
            if (defaultPackage == null || Name.isCompound(clasName))
                descriptor = "L" + clasName.replace('.', '/') + ";";
            else
                descriptor = "L" + defaultPackage.replace('.', '/') + "/" + clasName + ";";
        }
    }
    for (int i = 0; i < arrayDims; i++) descriptor = "[" + descriptor;
    this.descriptor = descriptor;
    //System.out.println("BSHType: returning descriptor: "+descriptor);
    return descriptor;
}