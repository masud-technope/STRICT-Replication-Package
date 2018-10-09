/**
	 * Opens a file. This may return null if the buffer could not be
	 * opened for some reason.
	 * @param editPane the EditPane to open the file in.
	 * @param parent The parent directory of the file
	 * @param path The path name of the file
	 * @param newFile True if the file should not be loaded from disk
	 * be prompted if it should be reloaded
	 * @param props Buffer-local properties to set in the buffer
	 *
	 * @return the buffer, or null if jEdit was unable to load it
	 *
	 * @since jEdit 4.3pre17
	 */
public static Buffer openFile(EditPane editPane, String parent, String path, boolean newFile, Hashtable<String, Object> props) {
    PerspectiveManager.setPerspectiveDirty(true);
    if (editPane != null && parent == null && editPane.getBuffer() != null)
        parent = editPane.getBuffer().getDirectory();
    try {
        URL u = new URL(path);
        if ("file".equals(u.getProtocol())) {
            path = URLDecoder.decode(u.getPath(), "UTF-8");
        }
    } catch (UnsupportedEncodingException e) {
        path = MiscUtilities.constructPath(parent, path);
    } catch (MalformedURLException e) {
        path = MiscUtilities.constructPath(parent, path);
    }
    if (props == null)
        props = new Hashtable<String, Object>();
    composeBufferPropsFromHistory(props, path);
    Buffer newBuffer;
    synchronized (editBusOrderingLock) {
        View view = editPane == null ? null : editPane.getView();
        synchronized (bufferListLock) {
            Buffer buffer = getBuffer(path);
            if (buffer != null) {
                if (editPane != null)
                    editPane.setBuffer(buffer, true);
                return buffer;
            }
            // if it is new, then it is untitled
            newBuffer = new Buffer(path, newFile, false, props, newFile);
            if (newBuffer.isBackup()) {
                Object[] args = { newBuffer.getName() };
                int result = GUIUtilities.option(view, "file-is-backup", args, JOptionPane.WARNING_MESSAGE, new String[] { jEdit.getProperty("file-is-backup.open"), jEdit.getProperty("file-is-backup.open-locked"), jEdit.getProperty("common.cancel") }, jEdit.getProperty("common.cancel"));
                if (result == 2)
                    return null;
                if (result == 1)
                    newBuffer.setLocked(true);
            }
            if (!newBuffer.load(view, false))
                return null;
            addBufferToList(newBuffer);
            if (editPane != null)
                bufferSetManager.addBuffer(editPane, newBuffer);
            else
                bufferSetManager.addBuffer(jEdit.getActiveView(), newBuffer);
        }
        EditBus.send(new BufferUpdate(newBuffer, view, BufferUpdate.CREATED));
    }
    if (editPane != null)
        editPane.setBuffer(newBuffer, true);
    return newBuffer;
}