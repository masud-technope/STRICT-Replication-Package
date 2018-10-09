//}}}
//{{{ _preprocessKeyEvent() method
private KeyEvent _preprocessKeyEvent(KeyEvent evt) {
    if (view.isClosed())
        return null;
    Component focusOwner = view.getFocusOwner();
    if (focusOwner instanceof JComponent) {
        JComponent comp = (JComponent) focusOwner;
        InputMap map = comp.getInputMap();
        ActionMap am = comp.getActionMap();
        if (map != null && am != null && comp.isEnabled()) {
            KeyStroke keyStroke = KeyStroke.getKeyStrokeForEvent(evt);
            Object binding = map.get(keyStroke);
            if (binding != null && am.get(binding) != null) {
                return null;
            }
        }
    }
    if (focusOwner instanceof JTextComponent) {
        // inside views are also handled by the input handler
        if (evt.getID() == KeyEvent.KEY_PRESSED) {
            switch(evt.getKeyCode()) {
                case KeyEvent.VK_ENTER:
                case KeyEvent.VK_TAB:
                case KeyEvent.VK_BACK_SPACE:
                case KeyEvent.VK_SPACE:
                    return null;
            }
        }
    }
    if (evt.isConsumed())
        return null;
    if (Debug.DUMP_KEY_EVENTS) {
        Log.log(Log.DEBUG, this, "Key event (preprocessing) : " + AbstractInputHandler.toString(evt));
    }
    return KeyEventWorkaround.processKeyEvent(evt);
}