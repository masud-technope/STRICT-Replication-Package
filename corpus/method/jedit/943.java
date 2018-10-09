// }}}
//{{{ getTitle() method
private static String getTitle(int mode) {
    switch(mode) {
        case VFSBrowser.OPEN_DIALOG:
            return jEdit.getProperty("vfs.browser.title.open");
        case VFSBrowser.SAVE_DIALOG:
            return jEdit.getProperty("vfs.browser.title.save");
        case VFSBrowser.BROWSER:
            return jEdit.getProperty("vfs.browser.title");
        case VFSBrowser.CHOOSE_DIRECTORY_DIALOG:
            return jEdit.getProperty("vfs.browser.title");
        case VFSBrowser.BROWSER_DIALOG:
            return jEdit.getProperty("vfs.browser.title.dialog");
        default:
            return jEdit.getProperty("vfs.browser.title");
    }
}