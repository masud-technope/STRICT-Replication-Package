public void visitLineNumber(final int line, final Label start) {
    if (CHECK) {
        if (start.owner != this || !start.resolved) {
            throw new IllegalArgumentException();
        }
    }
    if (lineNumber == null) {
        cw.newUTF8("LineNumberTable");
        lineNumber = new ByteVector();
    }
    ++lineNumberCount;
    lineNumber.put2(start.position);
    lineNumber.put2(line);
}