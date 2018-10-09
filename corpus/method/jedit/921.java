//{{{ filesActivated() method
public void filesActivated(VFSBrowser browser, VFSFile[] files) {
    filenameField.selectAll();
    if (files.length == 0) {
        // user pressed enter when the vfs table or
        // file name field has focus, with nothing
        // selected.
        ok();
        return;
    }
    for (int i = 0, n = files.length; i < n; i++) {
        if (files[i].getType() == VFSFile.FILE) {
            String path = files[i].getPath();
            VFS vfs = VFSManager.getVFSForPath(path);
            if (browser.getMode() == VFSBrowser.SAVE_DIALOG && vfs instanceof FileVFS) {
                if (doFileExistsWarning(path))
                    return;
            }
            isOK = true;
            filenameField.setText(null);
            if (browser.getMode() != VFSBrowser.CHOOSE_DIRECTORY_DIALOG) {
                dispose();
            }
            return;
        } else
            return;
    }
//}}}
}