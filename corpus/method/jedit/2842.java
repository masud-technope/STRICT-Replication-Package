//}}}
//{{{ addBufferSetListener() method
/**
	 * Add a BufferSetListener.
	 * @param listener the new BufferSetListener
	 */
public void addBufferSetListener(BufferSetListener listener) {
    Log.log(Log.DEBUG, this, hashCode() + ": addBufferSetListener " + listener);
    listeners.add(BufferSetListener.class, listener);
}