/**
	 * Displays a VFS file selection dialog box.
	 * This version can specify a frame as the parent instead
	 * of the view.
	 * @param parent The parent frame
	 * @param view The view, should be non-null
	 * @param path The initial directory to display. May be null
	 * @param type The dialog type. One of
	 * {@link org.gjt.sp.jedit.browser.VFSBrowser#OPEN_DIALOG},
	 * {@link org.gjt.sp.jedit.browser.VFSBrowser#SAVE_DIALOG}, or
	 * {@link org.gjt.sp.jedit.browser.VFSBrowser#CHOOSE_DIRECTORY_DIALOG}.
	 * @param multipleSelection True if multiple selection should be allowed
	 * @return The selected file(s)
	 * @since jEdit 4.3pre10
	 */
public static String[] showVFSFileDialog(Frame parent, View view, String path, int type, boolean multipleSelection) {
    hideSplashScreen();
    VFSFileChooserDialog fileChooser = new VFSFileChooserDialog(parent, view, path, type, multipleSelection, true);
    return fileChooser.getSelectedFiles();
}