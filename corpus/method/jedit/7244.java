//}}}
//{{{ removeStatusListener() method
/**
	 * Removes a scroll listener from this text area.
	 * @param listener The listener
	 * @since jEdit 4.3pre2
	 */
public final void removeStatusListener(StatusListener listener) {
    listenerList.remove(StatusListener.class, listener);
}