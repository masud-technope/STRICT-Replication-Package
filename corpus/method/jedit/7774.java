public void setMark(Buffer buffer, int pos) {
    String propName = makeBufferPropertyName(buffer, "emacs.mark");
    jEdit.setTemporaryProperty(propName, String.valueOf(pos));
}