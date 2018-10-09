/**
	 * Opens a file. Note that as of jEdit 2.5pre1, this may return
	 * null if the buffer could not be opened.
	 * @param editPane the EditPane to open the file in.
	 * @param path The file path
	 *
	 * @return the buffer, or null if jEdit was unable to load it
	 *
	 * @since jEdit 4.3pre17
	 */
public static Buffer openFile(EditPane editPane, String path) {
    return openFile(editPane, null, path, false, new Hashtable<String, Object>());
}