/**
	 * remove a buffer from all bufferSets.
	 *
	 * @param buffer the buffer that must be removed
	 */
public void removeBuffer(Buffer buffer) {
    for (BufferSet bufferSet : getOwners(buffer)) {
        bufferSet.removeBuffer(buffer);
        bufferRemoved(bufferSet);
    }
}