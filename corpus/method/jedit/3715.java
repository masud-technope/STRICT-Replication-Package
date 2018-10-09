//}}}
//{{{ parseKeyStroke() method
/**
         * Converts a string to a Swing KeyStroke. The string should be of the
	 * form <i>modifiers</i>+<i>shortcut</i> where <i>modifiers</i>
	 * is any combination of A for Alt, C for Control, S for Shift
	 * or M for Meta, and <i>shortcut</i> is either a single character,
	 * or a keycode name from the <code>KeyEvent</code> class, without
	 * the <code>VK_</code> prefix. Returns null if the string corresponds
	 * to multiple KeyStrokes (e.g., "C+e C+COMMA").
	 * @param shortcut A string description of the key stroke
	 * @since jEdit 5.0
         */
public static KeyStroke parseKeyStroke(String shortcut) {
    if (shortcut == null || shortcut.indexOf(' ') != -1)
        return null;
    String key;
    int modifiers = 0;
    String[] pieces = shortcut.split("\\+", 2);
    if (pieces.length == 1) {
        key = pieces[0];
    } else {
        modifiers = parseModifiers(pieces[0]);
        key = pieces[1];
    }
    if (key.length() == 1) {
        return KeyStroke.getKeyStroke(Character.valueOf(key.charAt(0)), modifiers);
    } else if (key.length() == 0) {
        Log.log(Log.ERROR, KeyEventTranslator.class, "Invalid key stroke: " + shortcut);
        return null;
    }
    int keyCode = parseKeyCode(key);
    if (keyCode == KeyEvent.VK_UNDEFINED) {
        return null;
    } else {
        return KeyStroke.getKeyStroke(keyCode, modifiers);
    }
}