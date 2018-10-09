//}}}
//{{{ bufferAdded() method
/**
	 * A buffer was added in the bufferSet.
	 * @param buffer the added buffer
	 * @param index the position where it was added
	 * @since jEdit 4.3pre15
	 */
public void bufferAdded(Buffer buffer, int index) {
    if (buffer == null)
        return;
    if (bufferSwitcher != null)
        bufferSwitcher.updateBufferList();
    if (bufferSet.indexOf(this.buffer) == -1) {
        // it happens when having 1 untitled buffer if I open a file. The untitled buffer
        // is closed but the new buffer is not yet opened
        setBuffer(buffer);
    }
}