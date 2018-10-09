//}}}
//{{{ parseKey() method
/**
	 * Converts a string to a keystroke. The string should be of the
	 * form <i>modifiers</i>+<i>shortcut</i> where <i>modifiers</i>
	 * is any combination of A for Alt, C for Control, S for Shift
	 * or M for Meta, and <i>shortcut</i> is either a single character,
	 * or a keycode name from the <code>KeyEvent</code> class, without
	 * the <code>VK_</code> prefix.
	 * @param keyStroke A string description of the key stroke
	 * @since jEdit 4.2pre3
	 */
public static Key parseKey(String keyStroke) {
    if (keyStroke == null)
        return null;
    String key;
    int modifiers = 0;
    String[] pieces = keyStroke.split("\\+", 2);
    if (pieces.length == 1) {
        key = pieces[0];
    } else {
        modifiers = parseModifiers(pieces[0]);
        key = pieces[1];
    }
    if (key.length() == 1) {
        return new Key(modifiersToString(modifiers), 0, key.charAt(0));
    } else if (key.length() == 0) {
        Log.log(Log.ERROR, KeyEventTranslator.class, "Invalid key stroke: " + keyStroke);
        return null;
    } else if (key.equals("SPACE")) {
        return new Key(modifiersToString(modifiers), 0, ' ');
    }
    int code = parseKeyCode(key);
    if (code == KeyEvent.VK_UNDEFINED) {
        return null;
    } else {
        return new Key(modifiersToString(modifiers), code, '\0');
    }
}