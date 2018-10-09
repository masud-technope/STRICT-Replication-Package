//}}}
//{{{ processKeyEvent() method
/**
	 * Forwards key events directly to the input handler.
	 * This is slightly faster than using a KeyListener
	 * because some Swing overhead is avoided.
	 */
@Override
public void processKeyEvent(KeyEvent evt) {
    inputHandler.processKeyEvent(evt, VIEW, false);
    if (!evt.isConsumed())
        super.processKeyEvent(evt);
}