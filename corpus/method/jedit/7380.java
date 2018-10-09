//}}}
//{{{ setThickCaretEnabled() method
/**
	 * Sets if the caret should be drawn with a thick line.
	 * @param thickCaret
	 *     True if the caret should be drawn as a block, false otherwise.
	 * @since jEdit 4.3pre15
	 */
public final void setThickCaretEnabled(boolean thickCaret) {
    this.thickCaret = thickCaret;
    if (textArea.getBuffer() != null)
        textArea.invalidateLine(textArea.getCaretLine());
}