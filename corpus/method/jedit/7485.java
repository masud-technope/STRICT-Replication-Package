//}}}
//{{{ processKeyEvent() method
/**
	 * Forwards key events directly to the input handler.
	 * This is slightly faster than using a KeyListener
	 * because some Swing overhead is avoided.
	 */
public void processKeyEvent(KeyEvent evt, boolean calledFromTextArea) {
    processKeyEvent(evt, calledFromTextArea ? TEXT_AREA : VIEW);
}