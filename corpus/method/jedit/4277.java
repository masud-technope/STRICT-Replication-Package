//}}}
//{{{ showVFSFileDialog() methods
/**
	 * Displays a VFS file selection dialog box.
	 * @param view The view, should be non-null
	 * @param path The initial directory to display. May be null
	 * @param type The dialog type. One of
	 * {@link org.gjt.sp.jedit.browser.VFSBrowser#OPEN_DIALOG},
	 * {@link org.gjt.sp.jedit.browser.VFSBrowser#SAVE_DIALOG}, or
	 * {@link org.gjt.sp.jedit.browser.VFSBrowser#CHOOSE_DIRECTORY_DIALOG}.
	 * @param multipleSelection True if multiple selection should be allowed
	 * @return The selected file(s)
	 * @since jEdit 2.6pre2
	 */
public static String[] showVFSFileDialog(View view, String path, int type, boolean multipleSelection) {
    // the view should not be null, but some plugins might do this
    if (view == null) {
        Log.log(Log.WARNING, GUIUtilities.class, "showVFSFileDialog(): given null view, assuming jEdit.getActiveView()");
        view = jEdit.getActiveView();
    }
    hideSplashScreen();
    VFSFileChooserDialog fileChooser = new VFSFileChooserDialog(view, path, type, multipleSelection);
    return fileChooser.getSelectedFiles();
}