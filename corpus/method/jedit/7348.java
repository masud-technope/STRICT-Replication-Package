//{{{ paintSelection() method
private void paintSelection(Graphics2D gfx, int screenLine, int physicalLine, int y, Selection s) {
    if ((physicalLine < s.getStartLine()) || (physicalLine > s.getEndLine()))
        return;
    float x = indent = textArea.getHorizontalOffset();
    float baseLine = y + getLineHeight() - (fm.getLeading() + 1) - fm.getDescent();
    DefaultTokenHandler tokenHandler = new DefaultTokenHandler();
    textArea.getBuffer().markTokens(physicalLine, tokenHandler);
    Token token = tokenHandler.getTokens();
    int lineStart = textArea.getLineStartOffset(physicalLine);
    int startOffset, endOffset;
    if (s instanceof Selection.Rect) {
        Selection.Rect r = (Selection.Rect) s;
        startOffset = r.getStart(textArea.getBuffer(), physicalLine);
        endOffset = r.getEnd(textArea.getBuffer(), physicalLine);
    } else {
        startOffset = (s.getStart() > lineStart) ? s.getStart() : lineStart;
        endOffset = s.getEnd();
    }
    // Soft-wrap
    int screenLineStart = textArea.getScreenLineStartOffset(screenLine);
    int screenLineEnd = textArea.getScreenLineEndOffset(screenLine);
    if (screenLineStart > startOffset)
        startOffset = screenLineStart;
    if (screenLineEnd < endOffset)
        endOffset = screenLineEnd;
    indentFound = false;
    int tokenStart = lineStart;
    while (token.id != Token.END) {
        int next = tokenStart + token.length;
        String sub = null;
        SyntaxStyle style = styles[token.id];
        if (// Reached selection start
        next > startOffset) {
            if (// Got past selection
            tokenStart >= endOffset)
                break;
            if (style != null) {
                gfx.setFont(style.getFont());
                gfx.setColor(getSelectionFgColor());
                int strStart;
                if (startOffset > tokenStart) {
                    strStart = startOffset;
                    x = nextX(x, style, sub, tokenStart, startOffset);
                } else
                    strStart = tokenStart;
                int strEnd = (endOffset > next) ? next : endOffset;
                sub = textArea.getText(strStart, strEnd - strStart);
                gfx.drawString(sub, x, baseLine);
                x = nextX(x, style, sub, strStart, strEnd);
            }
        }
        if (sub == null)
            x = nextX(x, style, null, tokenStart, next);
        tokenStart = next;
        token = token.next;
        if (tokenStart == screenLineStart)
            x = indent;
    }
//}}}
}