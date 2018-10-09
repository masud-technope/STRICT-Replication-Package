/**
	 * Opens a temporary buffer.
	 * Details: {@link #openTemporary(View, String, String, boolean)}
	 *
	 * @param view The view to open the file in
	 * @param parent The parent directory of the file
	 * @param path The path name of the file
	 * @param newFile True if the file should not be loaded from disk
	 * @param props Buffer-local properties to set in the buffer
         * @param untitled is the buffer untitled
	 *
	 * @return the buffer, or null if jEdit was unable to load it
	 *
	 * @since jEdit 4.3pre10
	 */
public static Buffer openTemporary(View view, String parent, String path, boolean newFile, Hashtable<String, Object> props, boolean untitled) {
    if (view != null && parent == null)
        parent = view.getBuffer().getDirectory();
    if (MiscUtilities.isURL(path)) {
        if ("file".equals(MiscUtilities.getProtocolOfURL(path)))
            path = path.substring(5);
    }
    path = MiscUtilities.constructPath(parent, path);
    if (props == null)
        props = new Hashtable<String, Object>();
    composeBufferPropsFromHistory(props, path);
    synchronized (bufferListLock) {
        Buffer buffer = getBuffer(path);
        if (buffer != null)
            return buffer;
        buffer = new Buffer(path, newFile, true, props, untitled);
        buffer.setBooleanProperty(Buffer.ENCODING_AUTODETECT, true);
        if (!buffer.load(view, false))
            return null;
        else
            return buffer;
    }
}