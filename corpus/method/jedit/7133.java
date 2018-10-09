//}}}
//{{{ addCaretListener() method
/**
	 * Adds a caret change listener to this text area.
	 * @param listener The listener
	 */
public final void addCaretListener(CaretListener listener) {
    listenerList.add(CaretListener.class, listener);
}