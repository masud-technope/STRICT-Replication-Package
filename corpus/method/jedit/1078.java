 BshMethod(BSHMethodDeclaration method, NameSpace declaringNameSpace, Modifiers modifiers) {
    this(method.name, method.returnType, method.paramsNode.getParamNames(), method.paramsNode.paramTypes, method.blockNode, declaringNameSpace, modifiers);
}