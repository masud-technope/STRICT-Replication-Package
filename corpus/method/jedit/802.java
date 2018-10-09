public void rename(String from) {
    VFS vfs = VFSManager.getVFSForPath(from);
    String filename = vfs.getFileName(from);
    String[] args = { filename };
    String to = GUIUtilities.input(this, "vfs.browser.rename", args, filename);
    if (to == null)
        return;
    rename(from, to);
}