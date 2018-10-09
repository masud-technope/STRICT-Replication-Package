/**
	 * Write a TarBuffer block to the archive.
	 */
private void writeBlock() throws IOException {
    if (this.debug) {
        System.err.println("WriteBlock: blkIdx = " + this.currBlkIdx);
    }
    if (this.outStream == null)
        throw new IOException("writing to an input buffer");
    this.outStream.write(this.blockBuffer, 0, this.blockSize);
    this.outStream.flush();
    this.currRecIdx = 0;
    this.currBlkIdx++;
}