//{{{ filesSelected() method
public void filesSelected(VFSBrowser browser, VFSFile[] files) {
    boolean choosingDir = (browser.getMode() == VFSBrowser.CHOOSE_DIRECTORY_DIALOG);
    if (files.length == 0) {
        if (choosingDir) {
            ok.setText(jEdit.getProperty("vfs.browser.dialog.choose-dir"));
        }
    } else if (files.length == 1) {
        if (choosingDir) {
            ok.setText(jEdit.getProperty("vfs.browser.dialog.choose-dir"));
        }
        VFSFile file = files[0];
        if (file.getType() == VFSFile.FILE) {
            String path = file.getPath();
            String directory = browser.getDirectory();
            String parent = MiscUtilities.getParentOfPath(path);
            if (MiscUtilities.pathsEqual(parent, directory))
                path = file.getName();
            filenameField.setText(path);
            filenameField.selectAll();
        }
    } else {
        if (choosingDir) {
            ok.setText(jEdit.getProperty("vfs.browser.dialog.choose-dir"));
        }
        filenameField.setText(null);
    }
//}}}
}