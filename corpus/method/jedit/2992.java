//}}}
//{{{ prevBuffer() method
/**
	 * Selects the previous buffer.
	 * @since jEdit 2.7pre2
	 */
public void prevBuffer() {
    Buffer buffer = bufferSet.getPreviousBuffer(bufferSet.indexOf(this.buffer));
    setBuffer(buffer);
}