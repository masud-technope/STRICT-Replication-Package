public int calculateIndent(JEditBuffer buffer, int line, int oldIndent, int newIndent) {
    int current = StandardUtilities.getLeadingWhiteSpaceWidth(buffer.getLineSegment(line), buffer.getTabSize());
    return (current < newIndent) ? current : newIndent;
}