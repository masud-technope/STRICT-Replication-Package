//}}}
//{{{ mergeBufferSets() method
/**
	 * Merge a EditPane's BufferSet into another one.
	 * This is used on unsplitting panes not to close buffers.
	 * @param target the target bufferSet where we will merge buffers from source
	 * @param source the source bufferSet
	 */
private static void mergeBufferSets(EditPane target, EditPane source) {
    BufferSetManager manager = jEdit.getBufferSetManager();
    for (Buffer buffer : source.getBufferSet().getAllBuffers()) {
        manager.addBuffer(target, buffer);
    }
}