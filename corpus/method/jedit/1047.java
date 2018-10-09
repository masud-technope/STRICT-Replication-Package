public String getTypeDescriptor(CallStack callstack, Interpreter interpreter, String defaultPackage) {
    if (jjtGetNumChildren() > 0)
        return ((BSHType) jjtGetChild(0)).getTypeDescriptor(callstack, interpreter, defaultPackage);
    else
        // this will probably not get used
        return // Object type
        "Ljava/lang/Object;";
}