//{{{ _closeBuffer() method
/**
	 * Closes the buffer, even if it has unsaved changes.
	 * @param view The view, may be null
	 * @param buffer The buffer
	 * @param doNotSave we do not want to keep the autosave file
	 *
	 * @exception NullPointerException if the buffer is null
	 *
	 * @since jEdit 2.2pre1
	 */
public static void _closeBuffer(View view, Buffer buffer, boolean doNotSave) {
    if (buffer.isClosed()) {
        // quick and the buffer has unsaved changes
        return;
    }
    // in case of a temporary buffer, just close it
    if (buffer.isTemporary()) {
        buffer.close();
        return;
    }
    PerspectiveManager.setPerspectiveDirty(true);
    if (!buffer.isNewFile()) {
        if (view != null)
            view.getEditPane().saveCaretInfo();
        Integer _caret = (Integer) buffer.getProperty(Buffer.CARET);
        int caret = _caret == null ? 0 : _caret.intValue();
        BufferHistory.setEntry(buffer.getPath(), caret, (Selection[]) buffer.getProperty(Buffer.SELECTION), buffer.getStringProperty(JEditBuffer.ENCODING), buffer.getMode().getName());
    }
    EditBus.send(new BufferUpdate(buffer, view, BufferUpdate.CLOSING));
    //FIXME: Duplicate code? Same is done in removeBufferFromList(buffer);
    String path = buffer.getSymlinkPath();
    if ((VFSManager.getVFSForPath(path).getCapabilities() & VFS.CASE_INSENSITIVE_CAP) != 0) {
        path = path.toLowerCase();
    }
    bufferHash.remove(path);
    removeBufferFromList(buffer);
    buffer.close(doNotSave);
    DisplayManager.bufferClosed(buffer);
    bufferSetManager.removeBuffer(buffer);
    EditBus.send(new BufferUpdate(buffer, view, BufferUpdate.CLOSED));
    if (jEdit.getBooleanProperty("persistentMarkers"))
        buffer.updateMarkersFile(view);
}