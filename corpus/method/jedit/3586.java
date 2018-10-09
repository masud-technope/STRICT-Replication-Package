//{{{ processKeyEvent() method
@Override
protected void processKeyEvent(KeyEvent _evt) {
    KeyEvent evt = KeyEventWorkaround.processKeyEvent(_evt);
    if (!KeyEventWorkaround.isBindable(_evt.getKeyCode()))
        evt = null;
    if (debugBuffer != null) {
        debugBuffer.insert(debugBuffer.getLength(), "Event " + AbstractInputHandler.toString(_evt) + (evt == null ? " filtered\n" : " passed\n"));
    }
    if (evt == null)
        return;
    evt.consume();
    KeyEventTranslator.Key key = KeyEventTranslator.translateKeyEvent(evt);
    if (Debug.DUMP_KEY_EVENTS) {
        Log.log(Log.DEBUG, GrabKeyDialog.class, "processKeyEvent() key=" + key + ", _evt=" + _evt + '.');
    }
    if (key == null)
        return;
    if (debugBuffer != null) {
        debugBuffer.insert(debugBuffer.getLength(), "==> Translated to " + key + '\n');
    }
    StringBuilder keyString = new StringBuilder(getShortcut());
    if (getDocument().getLength() != 0)
        keyString.append(' ');
    if (key.modifiers != null) {
        keyString.append(key.modifiers).append('+');
    }
    String symbolicName = getSymbolicName(key.key);
    if (symbolicName != null) {
        keyString.append(symbolicName);
    } else {
        if (key.input != '\0') {
            if (key.input == ' ') {
                keyString.append("SPACE");
            } else {
                keyString.append(key.input);
            }
        } else {
            return;
        }
    }
    setText(keyString.toString());
    if (debugBuffer == null)
        updateAssignedTo(keyString.toString());
//}}}
}