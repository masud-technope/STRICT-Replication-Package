//
//	/** the current ioTask of this buffer */
//	private volatile IoTask ioTask;
//}}}
//{{{ setPath() method
private void setPath(final String path) {
    jEdit.visit(new JEditVisitorAdapter() {

        @Override
        public void visit(EditPane editPane) {
            editPane.bufferRenamed(Buffer.this.path, path);
        }
    });
    this.path = path;
    VFS vfs = VFSManager.getVFSForPath(path);
    if ((vfs.getCapabilities() & VFS.WRITE_CAP) == 0)
        setFileReadOnly(true);
    name = vfs.getFileName(path);
    directory = vfs.getParentOfPath(path);
    if (vfs instanceof FileVFS) {
        file = new File(path);
        symlinkPath = MiscUtilities.resolveSymlinks(path);
        // deleted after a save as
        if (autosaveFile != null)
            autosaveFile.delete();
        setAutosaveFile();
    } else {
        // I wonder if the lack of this broke anything in the
        // past?
        file = null;
        autosaveFile = null;
        symlinkPath = path;
    }
}