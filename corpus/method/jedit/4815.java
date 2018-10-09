/**
	 * Opens a file. Note that as of jEdit 2.5pre1, this may return
	 * null if the buffer could not be opened.
	 * @param view The view to open the file in
	 * @param path The file path
	 *
	 * @return the buffer, or null if jEdit was unable to load it
	 *
	 * @since jEdit 2.4pre1
	 */
public static Buffer openFile(View view, String path) {
    return openFile(view, null, path, false, new Hashtable<String, Object>());
}