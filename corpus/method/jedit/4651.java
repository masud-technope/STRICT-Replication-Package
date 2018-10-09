//}}}
//{{{ _backup() method
/**
	 * Backs up the specified file. Default implementation in 5.0pre1
	 * copies the file to the backup directory. Before 5.0pre1 it was
	 * empty.
	 * @param session The VFS session
	 * @param path The path
	 * @param comp The component that will parent error dialog boxes
	 * @exception IOException if an I/O error occurs
	 * @since jEdit 3.2pre2
	 */
public void _backup(Object session, String path, Component comp) throws IOException {
    VFS vfsSrc = VFSManager.getVFSForPath(path);
    if (null == vfsSrc._getFile(session, path, comp))
        // file to backup does not exist
        return;
    // maybe the file is not applicable to local filesystem
    // but don't worry - for backup purposes it may be out
    // of a real filesystem
    File backupDir = MiscUtilities.prepareBackupDirectory(path);
    if (backupDir == null) {
        Log.log(Log.WARNING, VFS.class, "Backup of remote file " + path + " failed, because there is no backup directory.");
        return;
    }
    if (!backupDir.exists()) {
        // Usually that means there is no specified backup
        // directory.
        Log.log(Log.WARNING, VFS.class, "Backup of file " + path + " failed. Directory " + backupDir + " does not exist.");
        return;
    }
    File backupFile = MiscUtilities.prepareBackupFile(path, backupDir);
    if (backupFile == null) {
        return;
    }
    // do copy using VFS.copy
    VFS vfsDst = VFSManager.getVFSForPath(backupFile.getPath());
    Object sessionDst = vfsDst.createVFSSessionSafe(backupFile.getPath(), comp);
    if (sessionDst == null) {
        return;
    }
    try {
        if (!copy(null, vfsSrc, session, path, vfsDst, sessionDst, backupFile.getPath(), comp, true)) {
            Log.log(Log.WARNING, VFS.class, "Backup of file " + path + " failed. Copy to " + backupFile + " failed.");
        }
    } finally {
        vfsDst._endVFSSession(sessionDst, comp);
    }
}