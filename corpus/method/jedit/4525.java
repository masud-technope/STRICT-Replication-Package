//}}}
//{{{ processKeyEvent() method
/**
	 * Forwards key events directly to the input handler.
	 * This is slightly faster than using a KeyListener
	 * because some Swing overhead is avoided.
	 * @param evt the keyboard event
	 * @param from the source of the event. Since this is the input handler of the textarea, it should always be 1
	 * @param global it is only true if the event comes from the DefaultKeyboardFocusManager
	 * @since 4.3pre7
	 */
@Override
public void processKeyEvent(KeyEvent evt, int from, boolean global) {
    if (Debug.DUMP_KEY_EVENTS) {
        Log.log(Log.DEBUG, this, "Key event                 : " + toString(evt) + " from " + from);
    //	Log.log(Log.DEBUG,this,view+".isFocused()="+view.isFocused()+'.',new Exception());
    }
    if (evt.isConsumed())
        return;
    if (Debug.DUMP_KEY_EVENTS) {
        Log.log(Log.DEBUG, this, "Key event (preprocessing) : " + toString(evt));
    }
    evt = KeyEventWorkaround.processKeyEvent(evt);
    if (evt == null)
        return;
    if (Debug.DUMP_KEY_EVENTS) {
        Log.log(Log.DEBUG, this, "Key event after workaround: " + toString(evt) + " from " + from);
    }
    boolean focusOnTextArea = false;
    switch(evt.getID()) {
        case KeyEvent.KEY_TYPED:
            if (keyEventInterceptor != null)
                keyEventInterceptor.keyTyped(evt);
            else if (isPrefixActive() || textArea.hasFocus()) {
                processKeyEventKeyStrokeHandling(evt, from, "type ", global);
            }
            processKeyEventSub(focusOnTextArea);
            break;
        case KeyEvent.KEY_PRESSED:
            if (keyEventInterceptor != null)
                keyEventInterceptor.keyPressed(evt);
            else if (KeyEventWorkaround.isBindable(evt.getKeyCode())) {
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