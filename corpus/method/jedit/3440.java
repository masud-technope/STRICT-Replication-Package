private boolean isCloseBufferShortcut(KeyEvent evt) {
    String shortcut = GUIUtilities.getShortcutLabel("close-buffer", false);
    if (shortcut == null)
        return false;
    String[] s = shortcut.split(" or ");
    if (s.length == 1) // w/o alternative shortcut
    {
        if (//primary shortcut is a multiple-key shortcut
        s[0].contains(" "))
            return false;
        else
            return KeyEventTranslator.parseKey(s[0]).equals(KeyEventTranslator.translateKeyEvent(evt));
    }
    // w/ alternative shortcut
    boolean primarymatch, altmatch;
    primarymatch = altmatch = false;
    if (!s[0].contains(" "))
        primarymatch = KeyEventTranslator.parseKey(s[0]).equals(KeyEventTranslator.translateKeyEvent(evt));
    if (!primarymatch && !s[1].contains(" "))
        altmatch = KeyEventTranslator.parseKey(s[1]).equals(KeyEventTranslator.translateKeyEvent(evt));
    if (primarymatch || altmatch)
        return true;
    return false;
}