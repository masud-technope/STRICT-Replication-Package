public void _run() {
    try {
        VFSFile entry = vfs._getFile(session, path, browser);
        if (entry == null) {
            // non-existent file
            type[0] = VFSFile.FILE;
        } else
            type[0] = entry.getType();
    } catch (IOException e) {
        VFSManager.error(e, path, browser);
    } finally {
        try {
            vfs._endVFSSession(session, browser);
        } catch (IOException e) {
            VFSManager.error(e, path, browser);
        }
    }
}