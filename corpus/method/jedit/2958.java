//}}}
//{{{ bufferRemoved() method
/**
	 * A buffer was removed from the bufferSet.
	 * @param buffer the removed buffer
	 * @param index the position where it was before being removed
	 * @since jEdit 4.3pre15
	 */
public void bufferRemoved(Buffer buffer, int index) {
    if (buffer.isUntitled()) {
        // the buffer was a new file so I do not need to keep it's informations
        caretsForPath.remove(buffer.getPath());
    }
    if (buffer == this.buffer) {
        // The closed buffer is the current buffer
        Buffer newBuffer = recentBuffer != null ? recentBuffer : bufferSet.getPreviousBuffer(index);
        if (newBuffer != null && !newBuffer.isClosed()) {
            setBuffer(newBuffer);
            if (bufferSet.size() > 1) {
                recentBuffer = bufferSet.getPreviousBuffer(index - 1);
            }
        } else if (bufferSet.size() != 0) {
            setBuffer(bufferSet.getBuffer(0));
            recentBuffer = null;
        }
    }
    if (buffer == recentBuffer)
        recentBuffer = null;
    if (bufferSwitcher != null)
        bufferSwitcher.updateBufferList();
}