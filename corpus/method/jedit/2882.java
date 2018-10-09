//}}}
//{{{ bufferRemoved() method
/**
	 * This method is called when a buffer has been removed from a bufferSet.
	 * If it is empty, an untitled buffer is created and added to the bufferSet
	 * @param bufferSet the bufferSet from which the buffer was removed
	 */
private void bufferRemoved(BufferSet bufferSet) {
    if (bufferSet.size() == 0) {
        Buffer newEmptyBuffer = createUntitledBuffer();
        EditPane editPaneOwner = getOwner(bufferSet);
        addBuffer(editPaneOwner, newEmptyBuffer);
    }
}