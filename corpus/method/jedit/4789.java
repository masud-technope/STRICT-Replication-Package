//}}}
//{{{ _closeBuffer() method
/**
	 * Closes the buffer, even if it has unsaved changes.
	 * @param view The view, may be null
	 * @param buffer The buffer
	 *
	 * @exception NullPointerException if the buffer is null
	 *
	 * @since jEdit 2.2pre1
	 */
public static void _closeBuffer(View view, Buffer buffer) {
    _closeBuffer(view, buffer, true);
}