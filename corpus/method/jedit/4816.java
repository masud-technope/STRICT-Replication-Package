/**
	 * Opens a file. This may return null if the buffer could not be
	 * opened for some reason.
	 * @param view The view to open the file in. If it is null, the file
	 * will be opened and added to the bufferSet of the current edit pane,
	 * but not selected
	 * @param parent The parent directory of the file
	 * @param path The path name of the file
	 * @param newFile True if the file should not be loaded from disk
	 * be prompted if it should be reloaded
	 * @param props Buffer-local properties to set in the buffer
	 *
	 * @return the buffer, or null if jEdit was unable to load it
	 *
	 * @since jEdit 3.2pre10
	 */
public static Buffer openFile(View view, String parent, String path, boolean newFile, Hashtable<String, Object> props) {
    return openFile(view == null ? null : view.getEditPane(), parent, path, newFile, props);
}