//{{{ CommandsMenuButton constructor
 CommandsMenuButton() {
    setText(jEdit.getProperty("vfs.browser.commands.label"));
    GenericGUIUtilities.setAutoMnemonic(this);
    setName("commands");
    popup = new BrowserCommandsMenu(VFSBrowser.this, null);
//}}}
}