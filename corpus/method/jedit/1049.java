public String[] getTypeDescriptors(CallStack callstack, Interpreter interpreter, String defaultPackage) {
    if (typeDescriptors != null)
        return typeDescriptors;
    insureParsed();
    String[] typeDesc = new String[numArgs];
    for (int i = 0; i < numArgs; i++) {
        BSHFormalParameter param = (BSHFormalParameter) jjtGetChild(i);
        typeDesc[i] = param.getTypeDescriptor(callstack, interpreter, defaultPackage);
    }
    this.typeDescriptors = typeDesc;
    return typeDesc;
}