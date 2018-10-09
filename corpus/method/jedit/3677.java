//}}}
//{{{ processKeyEvent() method
/**
	 * Forwards key events directly to the input handler.
	 * This is slightly faster than using a KeyListener
	 * because some Swing overhead is avoided.
	 * @since 4.3pre7
	 */
@Override
public void processKeyEvent(KeyEvent evt, int from, boolean global) {
    if (Debug.DUMP_KEY_EVENTS) {
        Log.log(Log.DEBUG, this, "Key event                 : " + AbstractInputHandler.toString(evt) + " from " + from);
        Log.log(Log.DEBUG, this, view + ".isFocused()=" + view.isFocused() + '.', new Exception());
    }
    if (view.getTextArea().hasFocus() && from == View.VIEW)
        return;
    evt = _preprocessKeyEvent(evt);
    if (evt == null)
        return;
    if (Debug.DUMP_KEY_EVENTS) {
        Log.log(Log.DEBUG, this, "Key event after workaround: " + AbstractInputHandler.toString(evt) + " from " + from);
    }
    Component prefixFocusOwner = view.getPrefixFocusOwner();
    boolean focusOnTextArea = false;
    switch(evt.getID()) {
        case KeyEvent.KEY_TYPED:
            // after the prefix is done
            if (prefixFocusOwner != null) {
                if (prefixFocusOwner.isShowing()) {
                    prefixFocusOwner.requestFocus();
                    focusOnTextArea = true;
                }
            }
            if (keyEventInterceptor != null)
                keyEventInterceptor.keyTyped(evt);
            else if (from == View.ACTION_BAR || isPrefixActive() || view.getTextArea().hasFocus()) {
                processKeyEventKeyStrokeHandling(evt, from, "type ", global);
            }
            processKeyEventSub(focusOnTextArea);
            break;
        case KeyEvent.KEY_PRESSED:
            if (keyEventInterceptor != null)
                keyEventInterceptor.keyPressed(evt);
            else if (KeyEventWorkaround.isBindable(evt.getKeyCode())) {
                if (prefixFocusOwner != null) {
                    if (prefixFocusOwner.isShowing()) {
                        prefixFocusOwner.requestFocus();
                        focusOnTextArea = true;
                    }
                    view.setPrefixFocusOwner(null);
                }
                processKeyEventKeyStrokeHandling(evt, from, "press", global);
                processKeyEventSub(focusOnTextArea);
            }
            break;
        case KeyEvent.KEY_RELEASED:
            if (keyEventInterceptor != null)
                keyEventInterceptor.keyReleased(evt);
            break;
    }
}