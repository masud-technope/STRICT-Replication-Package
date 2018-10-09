//}}}
//{{{ autosave() method
/**
	 * Autosaves this buffer.
	 *
	 * @param force save even if AUTOSAVE_DIRTY not set
	 * @since jEdit 5.5pre1
	 */
public void autosave(boolean force) {
    if (autosaveFile == null || (!getFlag(AUTOSAVE_DIRTY) && !force) || !isDirty() || isPerformingIO() || !autosaveFile.getParentFile().exists())
        return;
    // re-set autosave file path, based on the path at the settings
    File autosaveFileOriginal = autosaveFile;
    setAutosaveFile();
    // if autosave path settings changed, delete the old file
    if (autosaveFile != null && !autosaveFileOriginal.toString().equals(autosaveFile.toString())) {
        autosaveFileOriginal.delete();
    }
    setFlag(AUTOSAVE_DIRTY, false);
    ThreadUtilities.runInBackground(new BufferAutosaveRequest(null, this, null, VFSManager.getFileVFS(), autosaveFile.getPath()));
}