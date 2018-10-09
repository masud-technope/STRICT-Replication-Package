//}}}
//{{{ getKeyBinding() method
private KeyBinding getKeyBinding(String shortcut) {
    if (shortcut == null || shortcut.length() == 0)
        return null;
    String spacedShortcut = shortcut + ' ';
    for (KeyBinding kb : allBindings) {
        if (!kb.isAssigned())
            continue;
        String spacedKbShortcut = kb.shortcut + ' ';
        // eg, trying to bind C+n C+p if C+n already bound
        if (spacedShortcut.startsWith(spacedKbShortcut))
            return kb;
        // eg, trying to bind C+e if C+e is a prefix
        if (spacedKbShortcut.startsWith(spacedShortcut)) {
            // KeyBinding, that won't be saved
            return new KeyBinding(kb.name, kb.label, kb.tooltip, shortcut, true);
        }
    }
    return null;
}