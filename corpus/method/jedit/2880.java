//}}}
//{{{ createUntitledBuffer() method
/**
	 * Create an untitled buffer
	 * @return the new untitled buffer
	 */
public static Buffer createUntitledBuffer() {
    int untitledCount = jEdit.getNextUntitledBufferId();
    View view = jEdit.getActiveView();
    String parent = null;
    if (view != null) {
        Buffer buffer = view.getBuffer();
        parent = buffer.getDirectory();
    }
    if (parent == null) {
        parent = MiscUtilities.getBackupDirectory();
    }
    VFS vfs = null;
    if (parent != null) {
        vfs = VFSManager.getVFSForPath(parent);
    }
    if (vfs != null && (vfs.getCapabilities() & VFS.WRITE_CAP) == 0) {
        // cannot write on that VFS, creating untitled buffer in home directory
        parent = System.getProperty("user.home");
    }
    Buffer newEmptyBuffer = jEdit.openTemporary(view, parent, "Untitled-" + untitledCount, true, true);
    jEdit.commitTemporary(newEmptyBuffer);
    return newEmptyBuffer;
}