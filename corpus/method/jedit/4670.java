/**
	 * Copy a file to another using VFS.
	 *
	 * @param progress the progress observer. It could be null if you don't want to monitor progress. If not null
	 *                  you should probably launch this command in a WorkThread
	 * @param sourceVFS the source VFS
	 * @param sourceSession the VFS session
	 * @param sourcePath the source path. It must be a file and must exists
	 * @param targetVFS the target VFS
	 * @param targetSession the target session
	 * @param targetPath the target path.
	 * If it is a path, it must exists, if it is a file, the parent must
	 * exists
	 * @param comp The component that will parent error dialog boxes
	 * @param canStop could this copy be stopped ?
	 * @param sendVFSUpdate true if you want to send a VFS update after the copy. False otherwise (if you do a lot
	 *                      of copy)
	 * @return true if the copy was successful
	 * @throws IOException  IOException If an I/O error occurs
	 * @since jEdit 5.0
	 */
public static boolean copy(ProgressObserver progress, VFS sourceVFS, Object sourceSession, String sourcePath, VFS targetVFS, Object targetSession, String targetPath, Component comp, boolean canStop, boolean sendVFSUpdate) throws IOException {
    if (sourcePath.equals(targetPath)) {
        Log.log(Log.WARNING, VFS.class, jEdit.getProperty("ioerror.copy-self", new Object[] { sourcePath }));
        return false;
    }
    if (progress != null)
        progress.setStatus("Initializing");
    InputStream in = null;
    OutputStream out = null;
    try {
        VFSFile sourceVFSFile = sourceVFS._getFile(sourceSession, sourcePath, comp);
        if (sourceVFSFile == null)
            throw new FileNotFoundException("source path " + sourcePath + " doesn't exists");
        if (progress != null) {
            progress.setMaximum(sourceVFSFile.getLength());
        }
        VFSFile targetVFSFile = targetVFS._getFile(targetSession, targetPath, comp);
        if (targetVFSFile == null) {
            String parentTargetPath = MiscUtilities.getParentOfPath(targetPath);
            VFSFile parentTargetVFSFile = targetVFS._getFile(targetSession, parentTargetPath, comp);
            if (parentTargetVFSFile == null)
                throw new FileNotFoundException("target path " + parentTargetPath + " doesn't exists");
            if (parentTargetVFSFile.getType() == VFSFile.DIRECTORY) {
                String targetFilename = MiscUtilities.getFileName(targetPath);
                targetPath = MiscUtilities.constructPath(parentTargetPath, targetFilename);
            } else {
                throw new IOException("The parent of target path is a file");
            }
        } else if (targetVFSFile.getType() == VFSFile.DIRECTORY) {
            if (targetVFSFile.getPath().equals(sourceVFSFile.getPath()))
                return false;
            targetPath = MiscUtilities.constructPath(targetPath, sourceVFSFile.getName());
        }
        in = new BufferedInputStream(sourceVFS._createInputStream(sourceSession, sourcePath, false, comp));
        out = new BufferedOutputStream(targetVFS._createOutputStream(targetSession, targetPath, comp));
        boolean copyResult = IOUtilities.copyStream(IOBUFSIZE, progress, in, out, canStop);
        if (sendVFSUpdate)
            VFSManager.sendVFSUpdate(targetVFS, targetPath, true);
        return copyResult;
    } finally {
        IOUtilities.closeQuietly((Closeable) in);
        IOUtilities.closeQuietly((Closeable) out);
    }
}