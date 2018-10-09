//}}}
//{{{ addBuffer() method
/**
	 * Internal use only, use
	 * {@link org.gjt.sp.jedit.bufferset.BufferSetManager#addBuffer(org.gjt.sp.jedit.View, org.gjt.sp.jedit.Buffer)}
	 * or
	 * {@link org.gjt.sp.jedit.bufferset.BufferSetManager#addBuffer(org.gjt.sp.jedit.EditPane, org.gjt.sp.jedit.Buffer)}
	 * @param buffer the buffer to be added
	 */
public void addBuffer(Buffer buffer) {
    addBufferAt(buffer, -1);
}