//}}}
//{{{ closeAllBuffers() methods
/**
	 * Closes all open buffers.
	 * @param view The view
	 *
	 * @return true if all buffers were closed, false otherwise
	 */
public static boolean closeAllBuffers(View view) {
    return closeAllBuffers(view, false);
}