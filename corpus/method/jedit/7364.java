//}}}
//{{{ setCursor() method
/**
	 * Change the mouse cursor.
	 * If the cursor is hiddenCursor or TEXT_CURSOR, it is the default cursor and the cursor will not disappear
	 * anymore while typing until {@link #resetCursor()} is called.
	 * @param cursor the new cursor
	 * @since jEdit 4.4pre1
	 */
public void setCursor(Cursor cursor) {
    defaultCursor = cursor == hiddenCursor || cursor.getType() == Cursor.TEXT_CURSOR;
    super.setCursor(cursor);
}