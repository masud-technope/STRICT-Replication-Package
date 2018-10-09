//}}}
//{{{ importText
private boolean importText(JComponent c, Transferable t) throws Exception {
    String str = (String) t.getTransferData(DataFlavor.stringFlavor);
    str = str.trim();
    Log.log(Log.DEBUG, this, "=> String \"" + str + '\"');
    JEditTextArea textArea = (JEditTextArea) c;
    if (dragSource == null) {
        boolean found = false;
        String[] components = str.split("\n");
        for (String str0 : components) {
            // Only examine the string for a URL if it came from
            // outside of jEdit.
            VFS vfs = VFSManager.getVFSForPath(str0);
            if (!(vfs instanceof FileVFS) || str.startsWith("file://")) {
                //					str = str.replace('\n',' ').replace('\r',' ').trim();
                if (str0.startsWith("file://")) {
                    str0 = str0.substring(7);
                }
                ThreadUtilities.runInBackground(new DraggedURLLoader(textArea, str0));
            }
            found = true;
        }
        if (found)
            return true;
    }
    if (dragSource != null && textArea.getBuffer() == dragSource.getBuffer()) {
        compoundEdit = true;
        textArea.getBuffer().beginCompoundEdit();
    }
    sameTextArea = textArea == dragSource;
    int caret = textArea.getCaretPosition();
    Selection s = textArea.getSelectionAtOffset(caret);
    /* if user drops into the same
		selection where they started, do
		nothing. */
    if (s != null) {
        if (sameTextArea)
            return false;
        /* if user drops into a selection,
			replace selection */
        int startPos = s.start;
        textArea.setSelectedText(s, str);
        textArea.setSelection(new Selection.Range(startPos, startPos + str.length()));
    } else /* otherwise just insert the text */
    {
        if (sameTextArea) {
            insertPos = caret;
            insertOffset = 0;
            Selection[] selections = textArea.getSelection();
            for (Selection selection : selections) {
                if (selection.end < insertPos + insertOffset)
                    insertOffset -= selection.end - selection.start;
            }
        } else {
            textArea.getBuffer().insert(caret, str);
            textArea.setSelection(new Selection.Range(caret, caret + str.length()));
        }
    }
    textArea.scrollToCaret(true);
    return true;
}