public  AlignBracket(JEditBuffer buffer, int line, int offset) {
    this.line = line;
    this.offset = offset;
    int openBracketIndex = TextUtilities.findMatchingBracket(buffer, this.line, this.offset);
    if (openBracketIndex == -1)
        openBracketLine = -1;
    else {
        openBracketLine = buffer.getLineOfOffset(openBracketIndex);
        openBracketColumn = openBracketIndex - buffer.getLineStartOffset(openBracketLine);
        openBracketLineText = buffer.getLineSegment(openBracketLine);
    }
}