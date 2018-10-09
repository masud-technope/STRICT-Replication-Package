//}}}
//{{{ contentInserted() method
public void contentInserted(JEditBuffer buffer, int startLine, int offset, int numLines, int length) {
    if (buffer.isLoading())
        return;
    displayManager.screenLineMgr.contentInserted(startLine, numLines);
    int endLine = startLine + numLines;
    if (numLines != 0)
        delayedMultilineUpdate = true;
    displayManager.folds.contentInserted(startLine, numLines);
    FirstLine firstLine = displayManager.firstLine;
    ScrollLineCount scrollLineCount = displayManager.scrollLineCount;
    if (textArea.getDisplayManager() == displayManager) {
        firstLine.contentInserted(startLine, numLines);
        scrollLineCount.contentInserted(startLine, numLines);
        if (delayedUpdateEnd >= startLine)
            delayedUpdateEnd += numLines;
        delayUpdate(startLine, endLine);
        //{{{ resize selections if necessary
        Iterator<Selection> iter = textArea.getSelectionIterator();
        while (iter.hasNext()) {
            Selection s = iter.next();
            if (s.contentInserted(buffer, startLine, offset, numLines, length)) {
                delayUpdate(s.startLine, s.endLine);
            }
        //}}}
        }
        int caret = textArea.getCaretPosition();
        if (caret >= offset) {
            int scrollMode = textArea.caretAutoScroll() ? TextArea.ELECTRIC_SCROLL : TextArea.NO_SCROLL;
            textArea.moveCaretPosition(caret + length, scrollMode);
        } else {
            int scrollMode = textArea.caretAutoScroll() ? TextArea.NORMAL_SCROLL : TextArea.NO_SCROLL;
            textArea.moveCaretPosition(caret, scrollMode);
        }
    } else {
        firstLine.setCallReset(true);
        scrollLineCount.setCallReset(true);
    }
}