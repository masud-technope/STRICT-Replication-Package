//}}}
//{{{ load() method
/**
	 * Loads the buffer from disk.
	 * @param view The view
	 * @param reload If true, user will not be asked to recover autosave
	 * file, if any
	 * @return true if loaded
	 * @since 2.5pre1
	 */
public boolean load(final View view, final boolean reload) {
    if (isPerformingIO()) {
        GUIUtilities.error(view, "buffer-multiple-io", null);
        return false;
    }
    setBooleanProperty(BufferIORequest.ERROR_OCCURRED, false);
    setLoading(true);
    // data available yet.
    if (!getFlag(TEMPORARY))
        EditBus.send(new BufferUpdate(this, view, BufferUpdate.LOAD_STARTED));
    final boolean loadAutosave;
    boolean autosaveUntitled = jEdit.getBooleanProperty("autosaveUntitled");
    // for untitled: re-read autosave file if enabled
    if (reload || !getFlag(NEW_FILE) || (isUntitled() && autosaveUntitled)) {
        if (file != null)
            modTime = file.lastModified();
        // Only on initial load
        if (!reload && autosaveFile != null && autosaveFile.exists())
            loadAutosave = recoverAutosave(view);
        else {
            if (autosaveFile != null)
                autosaveFile.delete();
            loadAutosave = false;
        }
        if (!loadAutosave) {
            VFS vfs = VFSManager.getVFSForPath(path);
            if (!checkFileForLoad(view, vfs, path)) {
                setLoading(false);
                return false;
            }
            // NEW_FILE flag
            if (reload || !getFlag(NEW_FILE)) {
                if (!vfs.load(view, this, path, isUntitled())) {
                    setLoading(false);
                    return false;
                }
            }
        }
    } else
        loadAutosave = false;
    //{{{ Do some stuff once loading is finished
    Runnable runnable = new Runnable() {

        public void run() {
            String newPath = getStringProperty(BufferIORequest.NEW_PATH);
            Segment seg = (Segment) getProperty(BufferIORequest.LOAD_DATA);
            IntegerArray endOffsets = (IntegerArray) getProperty(BufferIORequest.END_OFFSETS);
            loadText(seg, endOffsets);
            unsetProperty(BufferIORequest.LOAD_DATA);
            unsetProperty(BufferIORequest.END_OFFSETS);
            unsetProperty(BufferIORequest.NEW_PATH);
            undoMgr.clear();
            undoMgr.setLimit(jEdit.getIntegerProperty("buffer.undoCount", 100));
            // and reload markers.
            if (!getFlag(TEMPORARY))
                finishLoading();
            setLoading(false);
            // if reloading a file, clear dirty flag
            if (reload)
                setDirty(false);
            if (!loadAutosave && newPath != null)
                setPath(newPath);
            // redundant autosave file
            if (loadAutosave)
                Buffer.super.setDirty(true);
            // send some EditBus messages
            if (!getFlag(TEMPORARY)) {
                fireBufferLoaded();
                EditBus.send(new BufferUpdate(Buffer.this, view, BufferUpdate.LOADED));
            //EditBus.send(new BufferUpdate(Buffer.this,
            //	view,BufferUpdate.MARKERS_CHANGED));
            }
        }
    };
    if (getFlag(TEMPORARY))
        runnable.run();
    else
        AwtRunnableQueue.INSTANCE.runAfterIoTasks(runnable);
    return true;
}