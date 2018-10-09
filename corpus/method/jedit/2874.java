//}}}
//{{{ countBufferSets() method
/**
	 * Count the bufferSets in which the buffer is.
	 * @param buffer the buffer
	 * @return the number of buffersets in which buffer is
	 * @see org.gjt.sp.jedit.jEdit#closeBuffer(org.gjt.sp.jedit.EditPane, org.gjt.sp.jedit.Buffer)
	 */
public int countBufferSets(Buffer buffer) {
    return getOwners(buffer).size();
}