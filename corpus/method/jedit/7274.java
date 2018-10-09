//}}}
//{{{ isCaretVisible() method
/**
	 * Returns true if the caret is visible, false otherwise.
	 */
public final boolean isCaretVisible() {
    return blink && hasFocus();
}