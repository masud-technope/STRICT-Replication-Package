/**
	 * Write an archive record to the archive.
	 *
	 * @param record The record data to write to the archive.
	 */
public void writeRecord(byte[] record) throws IOException {
    if (this.debug) {
        System.err.println("WriteRecord: recIdx = " + this.currRecIdx + " blkIdx = " + this.currBlkIdx);
    }
    if (this.outStream == null)
        throw new IOException("writing to an input buffer");
    if (record.length != this.recordSize)
        throw new IOException("record to write has length '" + record.length + "' which is not the record size of '" + this.recordSize + "'");
    if (this.currRecIdx >= this.recsPerBlock) {
        this.writeBlock();
    }
    System.arraycopy(record, 0, this.blockBuffer, (this.currRecIdx * this.recordSize), this.recordSize);
    this.currRecIdx++;
}