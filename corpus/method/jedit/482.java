/**
	 * Write an archive record to the archive, where the record may be
	 * inside of a larger array buffer. The buffer must be "offset plus
	 * record size" long.
	 *
	 * @param buf The buffer containing the record data to write.
	 * @param offset The offset of the record data within buf.
	 */
public void writeRecord(byte[] buf, int offset) throws IOException {
    if (this.debug) {
        System.err.println("WriteRecord: recIdx = " + this.currRecIdx + " blkIdx = " + this.currBlkIdx);
    }
    if (this.outStream == null)
        throw new IOException("writing to an input buffer");
    if ((offset + this.recordSize) > buf.length)
        throw new IOException("record has length '" + buf.length + "' with offset '" + offset + "' which is less than the record size of '" + this.recordSize + "'");
    if (this.currRecIdx >= this.recsPerBlock) {
        this.writeBlock();
    }
    System.arraycopy(buf, offset, this.blockBuffer, (this.currRecIdx * this.recordSize), this.recordSize);
    this.currRecIdx++;
}