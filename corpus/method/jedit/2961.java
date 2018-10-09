//}}}
//{{{ bufferMoved() method
/**
	 * A buffer was moved in the BufferSet.
	 * @param buffer the moved buffer
	 * @param oldIndex the position it was before
	 * @param newIndex the new position
	 * @since jEdit 4.3pre15
	 */
public void bufferMoved(Buffer buffer, int oldIndex, int newIndex) {
    if (bufferSwitcher != null)
        bufferSwitcher.updateBufferList();
}