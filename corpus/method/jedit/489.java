/**
	 * Read a record from the input stream and return the data.
	 *
	 * @return The record data.
	 */
public byte[] readRecord() throws IOException {
    if (this.debug) {
        System.err.println("ReadRecord: recIdx = " + this.currRecIdx + " blkIdx = " + this.currBlkIdx);
    }
    if (this.inStream == null)
        throw new IOException("reading from an output buffer");
    if (this.currRecIdx >= this.recsPerBlock) {
        if (!this.readBlock())
            return null;
    }
    byte[] result = new byte[this.recordSize];
    System.arraycopy(this.blockBuffer, (this.currRecIdx * this.recordSize), result, 0, this.recordSize);
    this.currRecIdx++;
    return result;
}