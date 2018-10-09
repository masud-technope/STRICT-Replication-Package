//}}
//{{{ parseKeyCode() method
/**
	 * Parses the name of a keycode from the KeyEvent class to the the actual
	 * member of that class. (e.g., the string "VK_COMMA" becomes the integer
	 * KeyEvent.VK_COMMA). Returns KeyEvent.VK_UNDEFINED if no such member is found.
	 */
private static int parseKeyCode(String code) {
    try {
        return KeyEvent.class.getField("VK_".concat(code)).getInt(null);
    } catch (Exception e) {
        Log.log(Log.ERROR, KeyEventTranslator.class, "Invalid key code: " + code);
        return KeyEvent.VK_UNDEFINED;
    }
}