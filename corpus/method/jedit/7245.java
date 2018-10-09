//}}}
//}}}
//{{{ addStatusListener() method
/**
	 * Adds a scroll listener to this text area.
	 * @param listener The listener
	 * @since jEdit 4.3pre2
	 */
public final void addStatusListener(StatusListener listener) {
    listenerList.add(StatusListener.class, listener);
}