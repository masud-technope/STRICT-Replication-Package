/**
	 * Returns an array of all buffers in this bufferSet.
	 *
	 * @return an array of all Buffers
	 */
public Buffer[] getAllBuffers() {
    Buffer[] buffers = new Buffer[this.buffers.size()];
    return this.buffers.toArray(buffers);
}