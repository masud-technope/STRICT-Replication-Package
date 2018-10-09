String getReturnTypeDescriptor(CallStack callstack, Interpreter interpreter, String defaultPackage) {
    insureNodesParsed();
    if (returnTypeNode == null)
        return null;
    else
        return returnTypeNode.getTypeDescriptor(callstack, interpreter, defaultPackage);
}