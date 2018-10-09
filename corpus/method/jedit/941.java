//}}}
//{{{ doFileExistsWarning() method
private boolean doFileExistsWarning(String filename) {
    if (browser.getMode() == VFSBrowser.SAVE_DIALOG && new File(filename).exists()) {
        String[] args = { MiscUtilities.getFileName(filename) };
        int result = GUIUtilities.confirm(browser, "fileexists", args, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (result != JOptionPane.YES_OPTION)
            return true;
    }
    return false;
}