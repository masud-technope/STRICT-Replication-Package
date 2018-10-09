public int calculateIndent(JEditBuffer buffer, int line, int oldIndent, int newIndent) {
    return newIndent - buffer.getIndentSize();
}