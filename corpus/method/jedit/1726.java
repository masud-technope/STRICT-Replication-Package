public CodeVisitor visitMethod(final int access, final String name, final String desc, final String[] exceptions) {
    CodeWriter cw = new CodeWriter(this, computeMaxs);
    cw.init(access, name, desc, exceptions);
    return cw;
}