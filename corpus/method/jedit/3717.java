/**
	 * Pass this an event from {@link
	 * KeyEventWorkaround#processKeyEvent(java.awt.event.KeyEvent)}.
	 * @param evt the KeyEvent to translate
	 * @since jEdit 4.2pre3
	 */
public static Key translateKeyEvent(KeyEvent evt) {
    int modifiers = evt.getModifiersEx();
    Key returnValue;
    switch(evt.getID()) {
        case KeyEvent.KEY_PRESSED:
            int keyCode = evt.getKeyCode();
            if ((keyCode >= KeyEvent.VK_0 && keyCode <= KeyEvent.VK_9) || (keyCode >= KeyEvent.VK_A && keyCode <= KeyEvent.VK_Z)) {
                returnValue = new Key(modifiersToString(modifiers), '\0', Character.toLowerCase((char) keyCode));
            } else {
                if (keyCode == KeyEvent.VK_TAB) {
                    evt.consume();
                    returnValue = new Key(modifiersToString(modifiers), keyCode, '\0');
                } else if (keyCode == KeyEvent.VK_SPACE) {
                    // do a "<space> to insert ".
                    if ((modifiers & ~InputEvent.SHIFT_DOWN_MASK) == 0)
                        returnValue = null;
                    else
                        returnValue = new Key(modifiersToString(modifiers), 0, ' ');
                } else {
                    returnValue = new Key(modifiersToString(modifiers), keyCode, '\0');
                }
            }
            break;
        case KeyEvent.KEY_TYPED:
            char ch = evt.getKeyChar();
            switch(ch) {
                case '\n':
                case '\t':
                case '\b':
                    return null;
                case ' ':
                    if ((modifiers & ~InputEvent.SHIFT_DOWN_MASK) != 0)
                        return null;
            }
            int ignoreMods;
            if (Debug.ALT_KEY_PRESSED_DISABLED) {
                /* on MacOS, A+ can be user input */
                ignoreMods = InputEvent.SHIFT_DOWN_MASK | InputEvent.ALT_GRAPH_DOWN_MASK | InputEvent.ALT_DOWN_MASK;
            } else {
                /* on MacOS, A+ can be user input */
                ignoreMods = InputEvent.SHIFT_DOWN_MASK | InputEvent.ALT_GRAPH_DOWN_MASK;
            }
            if ((modifiers & InputEvent.ALT_GRAPH_DOWN_MASK) == 0 && (modifiers & ~ignoreMods) != 0) {
                return null;
            } else {
                if (ch == ' ') {
                    returnValue = new Key(modifiersToString(modifiers), 0, ch);
                } else
                    returnValue = new Key(null, 0, ch);
            }
            break;
        default:
            return null;
    }
    /* I guess translated events do not have the 'evt' field set
		so consuming won't work. I don't think this is a problem as
		nothing uses translation anyway */
    Key trans = transMap.get(returnValue);
    if (trans == null)
        return returnValue;
    else
        return trans;
}