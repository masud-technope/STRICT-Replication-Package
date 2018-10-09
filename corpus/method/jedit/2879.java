//}}}
//{{{ _removeBuffer() method
/**
	 * Remove a buffer from a bufferSet.
	 * Used when closing an EditPane
	 *
	 * @param bufferSet the bufferSet
	 * @param buffer the buffer that will be removed
	 */
private void _removeBuffer(BufferSet bufferSet, Buffer buffer) {
    Set<BufferSet> owners = getOwners(buffer);
    owners.remove(bufferSet);
    bufferSet.removeBuffer(buffer);
    if (owners.isEmpty()) {
        Log.log(Log.DEBUG, this, "Buffer:" + buffer + " is in no bufferSet anymore, closing it");
        jEdit._closeBuffer(null, buffer);
    }
}