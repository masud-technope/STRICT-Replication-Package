//}}}
//{{{ spacesToTabs() method
/**
	 * Converts spaces to tabs in the selection.
	 * @since jEdit 2.7pre2
	 */
public void spacesToTabs() {
    Selection[] selection = getSelection();
    if (!buffer.isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    buffer.beginCompoundEdit();
    if (selection.length == 0) {
        setText(TextUtilities.spacesToTabs(getText(), buffer.getTabSize()));
    } else {
        for (Selection s : selection) {
            setSelectedText(s, TextUtilities.spacesToTabs(getSelectedText(s), buffer.getTabSize()));
        }
    }
    buffer.endCompoundEdit();
}