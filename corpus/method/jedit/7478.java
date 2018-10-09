/**
	 * Forwards key events directly to the input handler.
	 * This is slightly faster than using a KeyListener
	 * because some Swing overhead is avoided.
	 */
public void processKeyEvent(KeyEvent evt, int from) {
    inputHandler.processKeyEvent(evt, from, false);
    if (!evt.isConsumed())
        super.processKeyEvent(evt);
}