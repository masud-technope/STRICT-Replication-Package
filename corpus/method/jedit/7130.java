//}}}
//{{{ removeCaretListener() method
/**
	 * Removes a caret change listener from this text area.
	 * @param listener The listener
	 */
public final void removeCaretListener(CaretListener listener) {
    listenerList.remove(CaretListener.class, listener);
}