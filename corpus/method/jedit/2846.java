//}}}
//{{{ removeBufferSetListener() method
/**
	 * Remove a BufferSetListener.
	 * If there are no listeners anymore, remove all buffers from the bufferSet.
	 * @param listener the removed BufferSetListener
	 */
public void removeBufferSetListener(BufferSetListener listener) {
    Log.log(Log.DEBUG, this, hashCode() + ": removeBufferSetListener " + listener);
    listeners.remove(BufferSetListener.class, listener);
}