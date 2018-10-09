//}}}
//{{{ transactionComplete() method
public void transactionComplete(JEditBuffer buffer) {
    if (textArea.getDisplayManager() != displayManager) {
        delayedUpdate = false;
        return;
    }
    if (delayedUpdate)
        doDelayedUpdate();
    textArea._finishCaretUpdate();
    delayedUpdate = false;
    //{{{ Debug code
    if (Debug.SCROLL_VERIFY) {
        int line = delayedUpdateStart;
        if (!displayManager.isLineVisible(line))
            line = displayManager.getNextVisibleLine(line);
        System.err.println(delayedUpdateStart + ":" + delayedUpdateEnd + ':' + textArea.getLineCount());
        int scrollLineCount = 0;
        while (line != -1 && line <= delayedUpdateEnd) {
            scrollLineCount += displayManager.getScreenLineCount(line);
            line = displayManager.getNextVisibleLine(line);
        }
        if (scrollLineCount != displayManager.getScrollLineCount()) {
            throw new InternalError(scrollLineCount + " != " + displayManager.getScrollLineCount());
        }
    //}}}
    }
}