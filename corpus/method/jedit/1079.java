 BshMethod(String name, Class returnType, String[] paramNames, Class[] paramTypes, BSHBlock methodBody, NameSpace declaringNameSpace, Modifiers modifiers) {
    this.name = name;
    this.creturnType = returnType;
    this.paramNames = paramNames;
    if (paramNames != null)
        this.numArgs = paramNames.length;
    this.cparamTypes = paramTypes;
    this.methodBody = methodBody;
    this.declaringNameSpace = declaringNameSpace;
    this.modifiers = modifiers;
}