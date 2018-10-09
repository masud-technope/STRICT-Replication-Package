static DelayedEvalBshMethod[] getDeclaredMethods(BSHBlock body, CallStack callstack, Interpreter interpreter, String defaultPackage) throws EvalError {
    List methods = new ArrayList();
    for (int child = 0; child < body.jjtGetNumChildren(); child++) {
        SimpleNode node = (SimpleNode) body.jjtGetChild(child);
        if (node instanceof BSHMethodDeclaration) {
            BSHMethodDeclaration md = (BSHMethodDeclaration) node;
            md.insureNodesParsed();
            Modifiers modifiers = md.modifiers;
            String name = md.name;
            String returnType = md.getReturnTypeDescriptor(callstack, interpreter, defaultPackage);
            BSHReturnType returnTypeNode = md.getReturnTypeNode();
            BSHFormalParameters paramTypesNode = md.paramsNode;
            String[] paramTypes = paramTypesNode.getTypeDescriptors(callstack, interpreter, defaultPackage);
            DelayedEvalBshMethod bm = new DelayedEvalBshMethod(name, returnType, returnTypeNode, md.paramsNode.getParamNames(), paramTypes, paramTypesNode, /*declaringNameSpace*/
            md.blockNode, null, modifiers, callstack, interpreter);
            methods.add(bm);
        }
    }
    return (DelayedEvalBshMethod[]) methods.toArray(new DelayedEvalBshMethod[0]);
}