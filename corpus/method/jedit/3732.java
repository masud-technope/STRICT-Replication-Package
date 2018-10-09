//}}}
//{{{ processKeyEvent() method
public static KeyEvent processKeyEvent(KeyEvent evt) {
    int keyCode = evt.getKeyCode();
    char ch = evt.getKeyChar();
    int modifiers = evt.getModifiersEx();
    switch(evt.getID()) {
        //{{{ KEY_PRESSED...
        case KeyEvent.KEY_PRESSED:
            // get rid of keys we never need to handle
            switch(keyCode) {
                case '\0':
                    return null;
                case KeyEvent.VK_ALT:
                case KeyEvent.VK_ALT_GRAPH:
                case KeyEvent.VK_CONTROL:
                case KeyEvent.VK_SHIFT:
                case KeyEvent.VK_META:
                    break;
                default:
                    if (!evt.isMetaDown()) {
                        if (!evt.isControlDown() && !evt.isAltDown()) {
                            if (isPrintable(keyCode)) {
                                return null;
                            }
                        }
                    }
                    if (Debug.ALT_KEY_PRESSED_DISABLED) {
                        /* they're too troublesome */
                        if ((modifiers & InputEvent.ALT_DOWN_MASK) != 0)
                            return null;
                    }
                    last = LAST_NOTHING;
                    break;
            }
            break;
        //{{{ KEY_TYPED...
        case KeyEvent.KEY_TYPED:
            // in HistoryTextFields
            if ((ch < 0x20 || ch == 0x7f || ch == 0xff) && ch != '\b' && ch != '\t' && ch != '\n') {
                return null;
            }
            if (Debug.DUMP_KEY_EVENTS) {
                Log.log(Log.DEBUG, "KEWa", "Key event (working around): " + AbstractInputHandler.toString(evt) + ": last=" + last + ".");
            }
            if ((modifiers & InputEvent.CTRL_DOWN_MASK) != 0 && (modifiers & InputEvent.ALT_DOWN_MASK) == 0 || (modifiers & InputEvent.CTRL_DOWN_MASK) == 0 && (modifiers & InputEvent.ALT_DOWN_MASK) != 0 && !Debug.ALT_KEY_PRESSED_DISABLED || (modifiers & InputEvent.META_DOWN_MASK) != 0) {
                return null;
            }
            // Windows JDK workaround
            if (last == LAST_ALT) {
                last = LAST_NOTHING;
                switch(ch) {
                    case 'B':
                    case 'M':
                    case 'X':
                    case 'c':
                    case '!':
                    case ',':
                    case '?':
                        return null;
                }
            }
            break;
        //{{{ KEY_RELEASED...
        case KeyEvent.KEY_RELEASED:
            switch(keyCode) {
                case KeyEvent.VK_ALT:
                    // we consume this to work around the bug
                    // where A+TAB window switching activates
                    // the menu bar on Windows.
                    // http://bugs.sun.com/view_bug.do?bug_id=6458497
                    //
                    // This should be removed if the fix for the
                    // above problem became widely available, to
                    // allow the menu bar activation.
                    evt.consume();
                    break;
                case KeyEvent.VK_ALT_GRAPH:
                case KeyEvent.VK_CONTROL:
                case KeyEvent.VK_SHIFT:
                case KeyEvent.VK_META:
                    break;
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_UP:
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_PAGE_UP:
                case KeyEvent.VK_PAGE_DOWN:
                case KeyEvent.VK_END:
                case KeyEvent.VK_HOME:
                    /* workaround for A+keys producing
				 * garbage on Windows */
                    if (modifiers == InputEvent.ALT_DOWN_MASK)
                        last = LAST_ALT;
                    break;
            }
            break;
    }
    return evt;
}