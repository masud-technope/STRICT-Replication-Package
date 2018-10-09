//}}}
//{{{ getBuffers() method
/**
	 * Returns an array of all open buffers from any View.
	 * @return  an array of all open buffers
	 * @see View#getBuffers()
	 */
public static Buffer[] getBuffers() {
    synchronized (bufferListLock) {
        Buffer[] buffers = new Buffer[bufferCount];
        Buffer buffer = buffersFirst;
        for (int i = 0; i < bufferCount; i++) {
            buffers[i] = buffer;
            buffer = buffer.next;
        }
        return buffers;
    }
}