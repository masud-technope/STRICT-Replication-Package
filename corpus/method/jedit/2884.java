/**
	 * Remove a buffer from a bufferSet.
	 * And make sure that the bufferSet is not empty after that
	 *
	 * @param bufferSet the bufferSet
	 * @param buffer the buffer that will be removed
	 */
void removeBuffer(BufferSet bufferSet, Buffer buffer) {
    Log.log(Log.DEBUG, this, "removeBuffer(" + bufferSet + ',' + buffer + ')');
    _removeBuffer(bufferSet, buffer);
    bufferRemoved(bufferSet);
}