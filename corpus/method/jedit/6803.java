//{{{ mouseDragged() method
public void mouseDragged(MouseEvent e) {
    /* && e.getX() >= getWidth() - borderWidth * 2 */
    if (drag) {
        e.translatePoint(-getWidth(), 0);
        textArea.mouseHandler.mouseDragged(e);
    } else if (selectLines) {
        int screenLine = e.getY() / textArea.getPainter().getLineHeight();
        int line;
        if (e.getY() < 0) {
            textArea.scrollUpLine();
            line = textArea.getFirstPhysicalLine();
        } else if (e.getY() >= getHeight()) {
            textArea.scrollDownLine();
            line = textArea.getLastPhysicalLine();
        } else
            line = textArea.chunkCache.getLineInfo(screenLine).physicalLine;
        int selStart, selEnd;
        if (line < selAnchorLine) {
            selStart = textArea.getLineStartOffset(line);
            selEnd = getFoldEndOffset(selAnchorLine);
            textArea.moveCaretPosition(selStart, false);
        } else {
            selStart = textArea.getLineStartOffset(selAnchorLine);
            selEnd = getFoldEndOffset(line);
            textArea.moveCaretPosition(selEnd, false);
        }
        textArea.resizeSelection(selStart, selEnd, 0, false);
    }
//}}}
}