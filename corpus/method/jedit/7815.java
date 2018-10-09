//}}}
//{{{ getKeymap() method
@Override
public Keymap getKeymap(String name) {
    File keymapFile = getKeymapFile(name);
    Keymap keymap = null;
    if (keymapFile.isFile())
        keymap = new KeymapImpl(name, keymapFile);
    return keymap;
}