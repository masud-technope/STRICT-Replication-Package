public void visitInnerClass(final String name, final String outerName, final String innerName, final int access) {
    if (innerClasses == null) {
        newUTF8("InnerClasses");
        innerClasses = new ByteVector();
    }
    ++innerClassesCount;
    innerClasses.put2(name == null ? 0 : newClass(name).index);
    innerClasses.put2(outerName == null ? 0 : newClass(outerName).index);
    innerClasses.put2(innerName == null ? 0 : newUTF8(innerName).index);
    innerClasses.put2(access);
}