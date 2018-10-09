//}}}
//{{{ indentSelectedLines() method
/**
	 * Indents all selected lines.
 	 * @since jEdit 3.1pre3
 	 */
public void indentSelectedLines() {
    if (!buffer.isEditable())
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
    else {
        buffer.indentLines(getSelectedLines());
        selectNone();
    }
}