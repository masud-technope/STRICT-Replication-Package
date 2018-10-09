//}}}
//{{{ getStatus() method
/**
	 * Returns the status bar. The
	 * {@link org.gjt.sp.jedit.gui.StatusBar#setMessage(String)} and
	 * {@link org.gjt.sp.jedit.gui.StatusBar#setMessageAndClear(String)} methods can
	 * be called on the return value of this method to display status
	 * information to the user.
	 * @since jEdit 3.2pre2
	 */
public StatusBar getStatus() {
    return status;
}