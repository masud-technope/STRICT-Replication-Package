//}}}
//{{{ reload() method
@Override
public void reload() {
    String name = getCurrentKeymapName();
    currentKeymap = getKeymap(name);
    if (currentKeymap == null)
        currentKeymap = getKeymap(DEFAULT_KEYMAP_NAME);
}