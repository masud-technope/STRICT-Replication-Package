/**
	 * Closes all open buffers.
	 * @param view The view
	 * @param isExiting This must be false unless this method is
	 * being called by the exit() method
	 *
	 * @return true if all buffers were closed, false otherwise
	 */
public static boolean closeAllBuffers(View view, boolean isExiting) {
    if (view != null)
        view.getEditPane().saveCaretInfo();
    boolean dirty = false;
    boolean saveRecent = !(isExiting && jEdit.getBooleanProperty("restore"));
    boolean autosaveUntitled = jEdit.getBooleanProperty("autosaveUntitled");
    boolean suppressNotSavedConfirmUntitled = jEdit.getBooleanProperty("suppressNotSavedConfirmUntitled") || autosaveUntitled;
    Buffer buffer = buffersFirst;
    while (buffer != null) {
        if (buffer.isDirty() && !(buffer.isUntitled() && suppressNotSavedConfirmUntitled)) {
            dirty = true;
            break;
        }
        buffer = buffer.next;
    }
    if (dirty) {
        boolean ok = new CloseDialog(view).isOK();
        if (!ok)
            return false;
    }
    // Wait for pending I/O requests
    TaskManager.instance.waitForIoTasks();
    if (VFSManager.errorOccurred())
        return false;
    // close remaining buffers (the close dialog only deals with
    // dirty ones)
    buffer = buffersFirst;
    // zero it here so that BufferTabs doesn't have any problems
    buffersFirst = buffersLast = null;
    bufferHash.clear();
    bufferCount = 0;
    while (buffer != null) {
        if ((!buffer.isNewFile() || (buffer.isUntitled() && autosaveUntitled)) && saveRecent) {
            Integer _caret = (Integer) buffer.getProperty(Buffer.CARET);
            int caret = _caret == null ? 0 : _caret.intValue();
            BufferHistory.setEntry(buffer.getPath(), caret, (Selection[]) buffer.getProperty(Buffer.SELECTION), buffer.getStringProperty(JEditBuffer.ENCODING), buffer.getMode().getName());
        }
        // do not delete untitled buffer when started with background
        if (!isExiting && !(buffer.isUntitled() && autosaveUntitled)) {
            EditBus.send(new BufferUpdate(buffer, view, BufferUpdate.CLOSING));
        }
        buffer.close();
        DisplayManager.bufferClosed(buffer);
        // do not delete untitled buffer when started with background
        if (!isExiting && !(buffer.isUntitled() && autosaveUntitled)) {
            bufferSetManager.removeBuffer(buffer);
            EditBus.send(new BufferUpdate(buffer, view, BufferUpdate.CLOSED));
        }
        if (jEdit.getBooleanProperty("persistentMarkers"))
            buffer.updateMarkersFile(view);
        buffer = buffer.next;
    }
    PerspectiveManager.setPerspectiveDirty(true);
    return true;
}