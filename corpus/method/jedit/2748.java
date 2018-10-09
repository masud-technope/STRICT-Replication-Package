/**
	 * Check if the buffer has changed on disk.
	 * @param view the View
	 * @return One of <code>FILE_NOT_CHANGED</code>, <code>FILE_CHANGED</code>, or
	 * <code>FILE_DELETED</code>.
	 *
	 * @since jEdit 4.2pre1
	 */
public int checkFileStatus(View view) {
    // - for untitled, do not check
    if (!isPerformingIO() && file != null && !getFlag(NEW_FILE) && !isUntitled()) {
        boolean newReadOnly = file.exists() && !file.canWrite();
        if (newReadOnly != isFileReadOnly()) {
            setFileReadOnly(newReadOnly);
            EditBus.send(new BufferUpdate(this, null, BufferUpdate.DIRTY_CHANGED));
        }
        long oldModTime = modTime;
        long newModTime = file.lastModified();
        if (newModTime != oldModTime) {
            modTime = newModTime;
            if (!file.exists()) {
                setFlag(NEW_FILE, true);
                setDirty(true);
                return FILE_DELETED;
            } else {
                return FILE_CHANGED;
            }
        }
    }
    return FILE_NOT_CHANGED;
}