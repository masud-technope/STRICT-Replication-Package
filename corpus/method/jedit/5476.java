//{{{ reset() method
void reset() {
    KeymapManager keymapManager = jEdit.getKeymapManager();
    Collection<String> keymapNames = keymapManager.getKeymapNames();
    keymaps = keymapNames.toArray(new String[keymapNames.size()]);
    if (!isValidName(selectedItem))
        selectedItem = keymaps[0];
    fireContentsChanged(this, 0, keymaps.length - 1);
//}}}
}