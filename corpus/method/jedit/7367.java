//}}}
//{{{ hideCursor() method
/**
	 * Hide the cursor if it is the default cursor
	 */
void hideCursor() {
    if (defaultCursor) {
        setCursor(hiddenCursor);
    }
}