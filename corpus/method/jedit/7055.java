//}}}
//{{{ addScrollListener() method
/**
	 * Adds a scroll listener to this text area.
	 * @param listener The listener
	 * @since jEdit 3.2pre2
	 */
public final void addScrollListener(ScrollListener listener) {
    listenerList.add(ScrollListener.class, listener);
}