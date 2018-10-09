//}}}
//{{{ saveAs() method
/**
	 * Prompts the user for a file to save this buffer to.
	 * @param view The view
	 * @param rename True if the buffer's path should be changed, false
	 * if only a copy should be saved to the specified filename
	 * @return true if the buffer was successfully saved
	 * @since jEdit 2.6pre5
	 */
public boolean saveAs(View view, boolean rename) {
    String fileSavePath = path;
    if (jEdit.getBooleanProperty("saveAsUsesFSB")) {
        DockableWindowManager dwm = view.getDockableWindowManager();
        Component comp = dwm.getDockable("vfs.browser");
        VFSBrowser browser = (VFSBrowser) comp;
        if (browser != null)
            fileSavePath = browser.getDirectory() + "/";
    }
    String[] files = GUIUtilities.showVFSFileDialog(view, fileSavePath, VFSBrowser.SAVE_DIALOG, false);
    // SAVE_DIALOG
    if (files == null)
        return false;
    boolean saved = save(view, files[0], rename);
    if (saved)
        setReadOnly(false);
    return saved;
}