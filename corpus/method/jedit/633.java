//}}}
//{{{ getProperty() method
public String getProperty(String name) {
    Keymap keymap = jEdit.getKeymapManager().getKeymap();
    return keymap.getShortcut(name);
}