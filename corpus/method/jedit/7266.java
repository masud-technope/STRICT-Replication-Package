//}}}
//{{{ _finishCaretUpdate() method
/* called by DisplayManager.BufferChangeHandler.transactionComplete() */
void _finishCaretUpdate() {
    if (!queuedCaretUpdate)
        return;
    try {
        if (match != null) {
            if (oldCaretLine < match.startLine)
                invalidateLineRange(oldCaretLine, match.endLine);
            else
                invalidateLineRange(match.startLine, oldCaretLine);
            match = null;
        }
        int newCaretScreenLine = chunkCache.getScreenLineOfOffset(caretLine, caret - buffer.getLineStartOffset(caretLine));
        if (caretScreenLine == -1)
            invalidateScreenLineRange(newCaretScreenLine, newCaretScreenLine);
        else
            invalidateScreenLineRange(caretScreenLine, newCaretScreenLine);
        caretScreenLine = newCaretScreenLine;
        invalidateSelectedLines();
        // When the user is typing, etc, we don't want the caret
        // to blink
        blink = true;
        caretTimer.restart();
        if (!displayManager.isLineVisible(caretLine)) {
            // islands of visible lines.
            if (displayManager.isOutsideNarrowing(caretLine)) {
                int collapseFolds = buffer.getIntegerProperty("collapseFolds", 0);
                if (collapseFolds != 0) {
                    displayManager.expandFolds(collapseFolds, false);
                    displayManager.expandFold(caretLine, false);
                    foldStructureChanged();
                } else
                    displayManager.expandAllFolds();
            } else
                displayManager.expandFold(caretLine, false);
        }
        if (queuedScrollMode == ELECTRIC_SCROLL)
            scrollToCaret(true);
        else if (queuedScrollMode == NORMAL_SCROLL)
            scrollToCaret(false);
        updateBracketHighlightWithDelay();
        if (queuedFireCaretEvent)
            fireCaretEvent();
    } finally // in case one of the above fails, we still want to
    // clear these flags.
    {
        queuedCaretUpdate = queuedFireCaretEvent = false;
        queuedScrollMode = NO_SCROLL;
    }
}