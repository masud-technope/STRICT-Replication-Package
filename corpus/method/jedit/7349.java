//{{{
float nextX(float x, SyntaxStyle style, String s, int startOffset, int endOffset) {
    if (s == null)
        s = textArea.getText(startOffset, endOffset - startOffset);
    if (s.equals("\t")) {
        int horzOffset = textArea.getHorizontalOffset();
        x = nextTabStop(x - horzOffset, endOffset) + horzOffset;
    } else {
        if ((!indentFound) && (!s.equals(" "))) {
            indentFound = true;
            indent = x;
        }
        Font font = (style != null) ? style.getFont() : getFont();
        x += font.getStringBounds(s, getFontRenderContext()).getWidth();
    }
    return x;
}