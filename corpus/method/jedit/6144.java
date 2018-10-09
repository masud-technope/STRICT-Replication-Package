//}}}
//{{{ _getFiles() method
@Override
protected String[] _getFiles(final Component comp) {
    boolean skipBinary, skipHidden;
    skipBinary = jEdit.getBooleanProperty("search.skipBinary.toggle");
    skipHidden = jEdit.getBooleanProperty("search.skipHidden.toggle");
    final VFS vfs = VFSManager.getVFSForPath(directory);
    Object session;
    session = vfs.createVFSSessionSafe(directory, comp);
    try {
        try {
            return vfs._listDirectory(session, directory, glob, recurse, comp, skipBinary, skipHidden);
        } finally {
            vfs._endVFSSession(session, comp);
        }
    } catch (IOException io) {
        VFSManager.error(comp, directory, "ioerror", new String[] { io.toString() });
        return null;
    }
}