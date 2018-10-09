//}}}
//{{{ processKeyEvent() method
/**
	 * Process a keyboard event.
	 * This is the entry point of the keyboard handling
	 *
	 * @param evt the keyboard event
	 * @param from the source, it can be {@link org.gjt.sp.jedit.View#VIEW},
	 * {@link org.gjt.sp.jedit.View#ACTION_BAR} or {@link org.gjt.sp.jedit.View#TEXT_AREA}
	 * @param global tell if the event comes from the DefaultKeyboardFocusManager or not
	 */
public abstract void processKeyEvent(KeyEvent evt, int from, boolean global);