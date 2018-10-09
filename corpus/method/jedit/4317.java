//}}}
//{{{ getShortcutLabel() method
/**
	 * Returns a label string to show users what shortcut are
	 * assigned to the action.
	 * @param platform if true, show fancy platform-specific label for the modifiers.
	 */
public static String getShortcutLabel(String action, Boolean platform) {
    if (action == null)
        return null;
    else {
        Keymap keymap = jEdit.getKeymapManager().getKeymap();
        String shortcut1 = keymap.getShortcut(action + ".shortcut");
        String shortcut2 = keymap.getShortcut(action + ".shortcut2");
        shortcut1 = platform ? getPlatformShortcutLabel(shortcut1) : shortcut1;
        shortcut2 = platform ? getPlatformShortcutLabel(shortcut2) : shortcut2;
        if (shortcut1 == null || shortcut1.length() == 0) {
            if (shortcut2 == null || shortcut2.length() == 0)
                return null;
            else
                return shortcut2;
        } else {
            if (shortcut2 == null || shortcut2.length() == 0)
                return shortcut1;
            else
                return shortcut1 + " or " + shortcut2;
        }
    }
}