//}}}
//{{{ sort() method
/**
	 * Sort the bufferSet (useful if a buffer has been renamed for example
	 * @since jEdit 4.4pre1
	 */
public void sort() {
    if (sorter == null)
        return;
    // do the sort
    Collections.sort(buffers, sorter);
    // notify the listeners so they can repaint themselves
    BufferSetListener[] listeners = this.listeners.getListeners(BufferSetListener.class);
    for (BufferSetListener listener : listeners) {
        listener.bufferSetSorted();
    }
}