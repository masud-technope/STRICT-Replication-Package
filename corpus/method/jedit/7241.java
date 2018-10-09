//}}}
//{{{ joinLines() method
/**
	 * Joins the current and the next line, or joins all lines in
	 * selections.
	 * @since jEdit 2.7pre2
	 */
public void joinLines() {
    if (!buffer.isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    try {
        buffer.beginCompoundEdit();
        boolean doneForSelection = false;
        for (Selection selection : selectionManager.getSelection()) {
            while (selection.startLine < selection.endLine) {
                // Edit from end of selection to
                // minimize invalidations and
                // recaluculations of cached line info
                // such as indent level or fold level.
                joinLineAt(selection.endLine - 1);
                doneForSelection = true;
            }
        }
        // one line, join the line at the caret.
        if (!doneForSelection) {
            int end = getLineEndOffset(caretLine);
            // Nothing to do if the caret is on the last line.
            if (end > buffer.getLength()) {
                javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
                return;
            }
            joinLineAt(caretLine);
            if (!multi)
                selectNone();
            moveCaretPosition(end - 1);
        }
    } finally {
        buffer.endCompoundEdit();
    }
}