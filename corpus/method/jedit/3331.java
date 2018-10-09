 KeyHandler(String dockableName) {
    KeymapManager keymapManager = jEdit.getKeymapManager();
    Keymap keymap = keymapManager.getKeymap();
    String shortcut1 = keymap.getShortcut(action + ".shortcut");
    String shortcut2 = keymap.getShortcut(action + ".shortcut2");
    if (shortcut1 != null)
        b1 = parseShortcut(shortcut1);
    if (shortcut2 != null)
        b2 = parseShortcut(shortcut2);
    name = dockableName;
    match1 = match2 = 0;
}