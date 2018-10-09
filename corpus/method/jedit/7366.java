//}}}
//{{{ showCursor() method
/**
	 * Show the cursor if it is the default cursor
	 */
void showCursor() {
    if (defaultCursor) {
        setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
    }
}