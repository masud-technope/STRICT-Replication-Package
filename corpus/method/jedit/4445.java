public int calculateIndent(JEditBuffer buffer, int line, int oldIndent, int newIndent) {
    if (openBracketLineText == null)
        return newIndent;
    else {
        return StandardUtilities.getLeadingWhiteSpaceWidth(openBracketLineText, buffer.getTabSize()) + (extraIndent * buffer.getIndentSize());
    }
}