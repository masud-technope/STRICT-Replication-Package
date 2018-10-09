//{{{ openTemporary() methods
/**
	 * Opens a temporary buffer. A temporary buffer is like a normal
	 * buffer, except that an event is not fired and the buffer is
	 * not added to the buffers list.
	 * <p>If a buffer for the given <code>path</code> was
	 * already opened in jEdit, then this instance is returned.
	 * Otherwise jEdit will not store a reference
	 * to the returned Buffer object.
	 * <p>This method is thread-safe.
	 *
	 * @param view The view to open the file in
	 * @param parent The parent directory of the file
	 * @param path The path name of the file
	 * @param newFile True if the file should not be loaded from disk
         * @param untitled is the buffer untitled
	 *
	 * @return the buffer, or null if jEdit was unable to load it
	 *
	 * @since jEdit 5.5pre1
	 */
public static Buffer openTemporary(View view, String parent, String path, boolean newFile, boolean untitled) {
    return openTemporary(view, parent, path, newFile, null, untitled);
}