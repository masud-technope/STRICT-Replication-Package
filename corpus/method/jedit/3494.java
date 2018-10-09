/**
	 * The FilePropertiesDialog's constructor
	 * @param view The view
	 * @param browser The VFSBrowser
	 */
public  FilePropertiesDialog(View view, VFSBrowser browser, VFSFile[] files) {
    super(view, jEdit.getProperty("vfs.browser.properties.title"), true);
    GUIUtilities.loadGeometry(this, "propdialog");
    this.browser = browser;
    if (files.length > 0)
        selectedFiles = files;
    else
        selectedFiles = browser.getSelectedFiles();
    local = selectedFiles[0];
    createAndShowGUI();
}