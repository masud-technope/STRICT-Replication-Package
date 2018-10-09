//}}}
//{{{ contentRemoved() method
public void contentRemoved(JEditBuffer buffer, int startLine, int start, int numLines, int length) {
    if (buffer.isLoading())
        return;
    FirstLine firstLine = displayManager.firstLine;
    ScrollLineCount scrollLineCount = displayManager.scrollLineCount;
    if (textArea.getDisplayManager() == displayManager) {
        firstLine.contentRemoved(startLine, start, numLines);
        scrollLineCount.contentRemoved(startLine, start, numLines);
        //{{{ resize selections if necessary
        int nSel = textArea.getSelectionCount();
        Iterator<Selection> iter = textArea.getSelectionIterator();
        while (iter.hasNext()) {
            Selection s = iter.next();
            if (s.contentRemoved(buffer, startLine, start, numLines, length)) {
                delayUpdate(s.startLine, s.endLine);
                if (nSel == 1 && s.start == s.end)
                    iter.remove();
            }
        //}}}
        }
        int caret = textArea.getCaretPosition();
        if (caret >= start + length) {
            int scrollMode = textArea.caretAutoScroll() ? TextArea.ELECTRIC_SCROLL : TextArea.NO_SCROLL;
            textArea.moveCaretPosition(caret - length, scrollMode);
        } else if (caret >= start) {
            int scrollMode = textArea.caretAutoScroll() ? TextArea.ELECTRIC_SCROLL : TextArea.NO_SCROLL;
            textArea.moveCaretPosition(start, scrollMode);
        } else {
            int scrollMode = textArea.caretAutoScroll() ? TextArea.NORMAL_SCROLL : TextArea.NO_SCROLL;
            textArea.moveCaretPosition(caret, scrollMode);
        }
    }
}