//}}}
//{{{ createCustomMenu() method
private JMenu createCustomMenu() {
    if (jEdit.getProperty("browser.custom.context", "").length() != 0) {
        JMenu custom = GUIUtilities.loadMenu(VFSBrowser.getActionContext(), "browser.custom.context");
        return custom;
    }
    return null;
}