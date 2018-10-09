/**
	 * Skip over a record on the input stream.
	 */
public void skipRecord() throws IOException {
    if (this.debug) {
        System.err.println("SkipRecord: recIdx = " + this.currRecIdx + " blkIdx = " + this.currBlkIdx);
    }
    if (this.inStream == null)
        throw new IOException("reading (via skip) from an output buffer");
    if (this.currRecIdx >= this.recsPerBlock) {
        if (!this.readBlock())
            // UNDONE
            return;
    }
    this.currRecIdx++;
}