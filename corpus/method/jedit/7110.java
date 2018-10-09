//}}}
//{{{ shiftIndentLeft() method
/**
	 * Shifts the indent to the left.
	 * @since jEdit 2.7pre2
	 */
public void shiftIndentLeft() {
    if (!buffer.isEditable())
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
    else {
        buffer.shiftIndentLeft(getSelectedLines());
    }
}