//}}}
//{{{ blinkCaret() method
/**
	 * Blinks the caret.
	 */
public final void blinkCaret() {
    if (caretBlinks) {
        blink = !blink;
        invalidateLine(caretLine);
    } else
        blink = true;
}