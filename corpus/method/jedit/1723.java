// --------------------------------------------------------------------------
// Implementation of the ClassVisitor interface
// --------------------------------------------------------------------------
public void visit(final int access, final String name, final String superName, final String[] interfaces, final String sourceFile) {
    this.access = access;
    this.name = newClass(name).index;
    this.superName = superName == null ? 0 : newClass(superName).index;
    if (interfaces != null && interfaces.length > 0) {
        interfaceCount = interfaces.length;
        this.interfaces = new int[interfaceCount];
        for (int i = 0; i < interfaceCount; ++i) {
            this.interfaces[i] = newClass(interfaces[i]).index;
        }
    }
    if (sourceFile != null) {
        newUTF8("SourceFile");
        this.sourceFile = newUTF8(sourceFile);
    }
    if ((access & Constants.ACC_DEPRECATED) != 0) {
        newUTF8("Deprecated");
    }
}