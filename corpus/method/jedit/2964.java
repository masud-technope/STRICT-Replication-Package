//}}}
//{{{ getBufferSet() method
/**
	 * Returns the current buffer set.
	 * This can be changed by setBufferSetScope().
	 * @return the buffer set which is currently used by this EditPane
	 * @since jEdit 4.3pre17
	 */
public BufferSet getBufferSet() {
    return bufferSet;
}