//{{{ PluginsMenuButton constructor
 PluginsMenuButton() {
    setText(jEdit.getProperty("vfs.browser.plugins.label"));
    GenericGUIUtilities.setAutoMnemonic(this);
    setName("plugins");
    setMargin(new Insets(1, 1, 1, 1));
    popup = null;
    createPopupMenu();
//}}}
}