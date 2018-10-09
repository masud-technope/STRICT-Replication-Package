//}}}
//{{{ removeScrollListener() method
/**
	 * Removes a scroll listener from this text area.
	 * @param listener The listener
	 * @since jEdit 3.2pre2
	 */
public final void removeScrollListener(ScrollListener listener) {
    listenerList.remove(ScrollListener.class, listener);
}