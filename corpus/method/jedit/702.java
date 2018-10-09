//}}}
//{{{ createPluginsMenu() method
private JMenu createPluginMenu(VFSBrowser browser) {
    JMenu pluginMenu = new JMenu(jEdit.getProperty("vfs.browser.plugins.label"));
    GenericGUIUtilities.setAutoMnemonic(pluginMenu);
    return (JMenu) browser.createPluginsMenu(pluginMenu, false);
}