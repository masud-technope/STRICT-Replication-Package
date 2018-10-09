//}}}
//{{{ scrollToCaret() method
/**
	 * Ensures that the caret is visible by scrolling the text area if
	 * necessary.
	 * @param doElectricScroll If true, electric scrolling will be performed
	 */
public void scrollToCaret(boolean doElectricScroll) {
    scrollTo(caretLine, caret - buffer.getLineStartOffset(caretLine), doElectricScroll);
}