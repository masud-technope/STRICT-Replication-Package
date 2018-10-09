@Override
public void migrate() {
    String settingsDirectory = jEdit.getSettingsDirectory();
    if (settingsDirectory == null)
        return;
    File keymapFolder = new File(settingsDirectory, "keymaps");
    if (keymapFolder.exists())
        return;
    KeymapManager keymapManager = jEdit.getKeymapManager();
    keymapManager.copyKeymap(KeymapManager.DEFAULT_KEYMAP_NAME, "imported");
    Keymap imported = keymapManager.getKeymap("imported");
    Properties properties = jEdit.getProperties();
    Set<Map.Entry<Object, Object>> entries = properties.entrySet();
    for (Map.Entry<Object, Object> entry : entries) {
        String key = entry.getKey().toString();
        if ((key.endsWith(".shortcut") || key.endsWith(".shortcut2")) && !key.startsWith("options.shortcuts.")) {
            imported.setShortcut(key, entry.getValue().toString());
            jEdit.resetProperty(key);
        }
    }
    imported.save();
    jEdit.setProperty("keymap.current", "imported");
    keymapManager.reload();
}