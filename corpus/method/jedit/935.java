//}}}
//{{{ getSelectedFiles() method
public String[] getSelectedFiles() {
    if (!isOK)
        return null;
    if (browser.getMode() == VFSBrowser.CHOOSE_DIRECTORY_DIALOG) {
        if (browser.getSelectedFiles().length > 0) {
            return getSelectedFiles(VFSFile.DIRECTORY, VFSFile.FILESYSTEM);
        } else
            return new String[] { browser.getDirectory() };
    } else if (filename != null && filename.length() != 0) {
        String path = browser.getDirectory();
        return new String[] { MiscUtilities.constructPath(path, filename) };
    } else
        return getSelectedFiles(VFSFile.FILE, VFSFile.FILE);
}