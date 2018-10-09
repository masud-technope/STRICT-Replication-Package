//{{{ getMacShortcutLabel() method
/**
	 * Convert a shortcut label to a Mac-friendly version by changing written-out
	 * names and modifiers (e.g. C+PERIOD) to symbols.
	 */
private static String getMacShortcutLabel(String label) {
    StringBuilder out = new StringBuilder();
    // Show the list of modifiers in standard order
    int endOfModifiers = label.indexOf('+');
    if (endOfModifiers != -1) {
        String modifiers = label.substring(0, endOfModifiers).toUpperCase();
        if (modifiers.indexOf('A') != -1) {
            // ctrl
            out.append(// ctrl
            '?');
        }
        if (modifiers.indexOf('M') != -1) {
            // alt
            out.append(// alt
            '?');
        }
        if (modifiers.indexOf('S') != -1) {
            // shift
            out.append(// shift
            '?');
        }
        if (modifiers.indexOf('C') != -1) {
            // cmd
            out.append(// cmd
            '?');
        }
    }
    // We've done the modifiers, now do the key
    String key = label.substring(endOfModifiers + 1);
    // Some keys have Mac-specific symbols
    String text = macKeySymbols.get(key);
    // Others don't
    if (text == null) {
        // character
        try {
            // e.g., convert the string "PERIOD" to the int KeyEvent.VK_PERIOD
            int keyCode = KeyEvent.class.getField("VK_".concat(key)).getInt(null);
            // And then convert KeyEvent.VK_PERIOD to the string "."
            text = KeyEvent.getKeyText(keyCode).toUpperCase();
        } catch (Exception e) {
            text = key.toUpperCase();
        }
    }
    out.append(text);
    return out.toString();
}