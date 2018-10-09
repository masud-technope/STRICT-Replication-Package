public int calculateIndent(JEditBuffer buffer, int line, int oldIndent, int newIndent) {
    return openParensColumn + 1;
}