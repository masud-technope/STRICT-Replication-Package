public String getTypeDescriptor(CallStack callstack, Interpreter interpreter, String defaultPackage) {
    if (isVoid)
        return "V";
    else
        return getTypeNode().getTypeDescriptor(callstack, interpreter, defaultPackage);
}