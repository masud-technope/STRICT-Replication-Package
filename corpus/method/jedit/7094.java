//}}}
//{{{ tabsToSpaces() method
/**
	 * Converts tabs to spaces in the selection.
	 * @since jEdit 2.7pre2
	 */
public void tabsToSpaces() {
    Selection[] selection = getSelection();
    if (!buffer.isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    buffer.beginCompoundEdit();
    if (selection.length == 0) {
        setText(TextUtilities.tabsToSpaces(getText(), buffer.getTabSize()));
    } else {
        for (Selection s : selection) {
            setSelectedText(s, TextUtilities.tabsToSpaces(getSelectedText(s), buffer.getTabSize()));
        }
    }
    buffer.endCompoundEdit();
}