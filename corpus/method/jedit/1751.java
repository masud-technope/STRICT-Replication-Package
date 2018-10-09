public void visitLocalVariable(final String name, final String desc, final Label start, final Label end, final int index) {
    if (CHECK) {
        if (start.owner != this || !start.resolved) {
            throw new IllegalArgumentException();
        }
        if (end.owner != this || !end.resolved) {
            throw new IllegalArgumentException();
        }
    }
    if (localVar == null) {
        cw.newUTF8("LocalVariableTable");
        localVar = new ByteVector();
    }
    ++localVarCount;
    localVar.put2(start.position);
    localVar.put2(end.position - start.position);
    localVar.put2(cw.newUTF8(name).index);
    localVar.put2(cw.newUTF8(desc).index);
    localVar.put2(index);
}