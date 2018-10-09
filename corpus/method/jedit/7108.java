//}}}
//{{{ shiftIndentRight() method
/**
	 * Shifts the indent to the right.
	 * @since jEdit 2.7pre2
	 */
public void shiftIndentRight() {
    if (!buffer.isEditable())
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
    else
        buffer.shiftIndentRight(getSelectedLines());
}