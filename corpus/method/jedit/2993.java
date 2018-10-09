//}}}
//{{{ nextBuffer() method
/**
	 * Selects the next buffer.
	 * @since jEdit 2.7pre2
	 */
public void nextBuffer() {
    Buffer buffer = bufferSet.getNextBuffer(bufferSet.indexOf(this.buffer));
    setBuffer(buffer);
}