//{{{ getShortcut() method
private String getShortcut() {
    if (shortcut == '\0')
        return null;
    else {
        String shortcutPrefix = jEdit.getProperty(shortcutProp);
        if (shortcutPrefix == null)
            return null;
        else {
            return shortcutPrefix + ' ' + shortcut;
        }
    }
//}}}
}