//}}}
//{{{ setCaretColor() method
/**
	 * Sets the caret color.
	 * @param caretColor The caret color
	 */
public final void setCaretColor(Color caretColor) {
    this.caretColor = caretColor;
    if (textArea.getBuffer() != null)
        textArea.invalidateLine(textArea.getCaretLine());
}