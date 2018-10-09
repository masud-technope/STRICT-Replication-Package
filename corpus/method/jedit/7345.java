@Override
public void paintValidLine(Graphics2D gfx, int screenLine, int physicalLine, int start, int end, int y) {
    if (!textArea.isCaretVisible())
        return;
    int caret = textArea.getCaretPosition();
    if (caret < start || caret >= end)
        return;
    int offset = caret - textArea.getLineStartOffset(physicalLine);
    textArea.offsetToXY(physicalLine, offset, textArea.offsetXY);
    int caretX = textArea.offsetXY.x;
    int lineHeight = getLineHeight();
    int charHeight = Math.min(lineHeight, getFontHeight());
    int charOffset = Math.max(lineHeight - charHeight, 0);
    gfx.setColor(caretColor);
    if (textArea.isOverwriteEnabled()) {
        if (thickCaret)
            gfx.fillRect(caretX, y + lineHeight - 4, textArea.charWidth, 3);
        else
            gfx.drawLine(caretX, y + lineHeight - 1, caretX + textArea.charWidth, y + lineHeight - 1);
    } else if (blockCaret)
        gfx.drawRect(caretX, y + charOffset, textArea.charWidth - 1, charHeight - 1);
    else {
        if (thickCaret)
            gfx.fillRect(caretX, y + charOffset, 3, charHeight - 1);
        else
            gfx.drawLine(caretX, y + charOffset, caretX, y + charOffset + charHeight - 1);
    }
}