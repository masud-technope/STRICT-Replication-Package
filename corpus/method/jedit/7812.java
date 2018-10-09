//{{{ KeymapManagerImpl() constructor
public  KeymapManagerImpl(IPropertyManager propertyManager, File systemKeymapFolder, File userKeymapFolder) {
    this.propertyManager = propertyManager;
    this.systemKeymapFolder = systemKeymapFolder;
    if (!systemKeymapFolder.isDirectory()) {
        Log.log(Log.ERROR, this, "System keymap folder do not exist, your installation is broken. " + "Install keymaps in " + systemKeymapFolder.getAbsolutePath());
        JOptionPane.showMessageDialog(null, "System keymap folder do not exist, your installation is broken. " + "Install keymaps in " + systemKeymapFolder.getAbsolutePath(), "Fatal Error", JOptionPane.ERROR_MESSAGE);
        System.exit(10);
    }
    KeymapManagerImpl.userKeymapFolder = userKeymapFolder;
}