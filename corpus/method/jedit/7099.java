//}}}
//{{{ setCaretBlinkEnabled() method
/**
	 * Toggles caret blinking.
	 * @param caretBlinks True if the caret should blink, false otherwise
	 */
public void setCaretBlinkEnabled(boolean caretBlinks) {
    this.caretBlinks = caretBlinks;
    if (!caretBlinks)
        blink = false;
    if (buffer != null)
        invalidateLine(caretLine);
}