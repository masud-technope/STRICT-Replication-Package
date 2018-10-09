/**
	 * Opens a temporary buffer.
	 * Details: {@link #openTemporary(View, String, String, boolean)}
	 *
	 * @param view The view to open the file in
	 * @param parent The parent directory of the file
	 * @param path The path name of the file
	 * @param newFile True if the file should not be loaded from disk
	 * @param props Buffer-local properties to set in the buffer
	 *
	 * @return the buffer, or null if jEdit was unable to load it
	 *
	 * @since jEdit 4.3pre10
	 */
public static Buffer openTemporary(View view, String parent, String path, boolean newFile, Hashtable<String, Object> props) {
    return openTemporary(view, parent, path, newFile, null, false);
}