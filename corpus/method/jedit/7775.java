public int getMark(Buffer buffer) {
    String propName = makeBufferPropertyName("emacs.mark");
    int mark = getCardinalProperty(propName, -1);
    if (mark != -1 && mark >= buffer.getLength()) {
        mark = buffer.getLength() - 1;
    }
    return mark;
}