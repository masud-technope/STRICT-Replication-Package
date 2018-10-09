/**
	 * @return false if End-Of-File, else true
	 */
private boolean readBlock() throws IOException {
    if (this.debug) {
        System.err.println("ReadBlock: blkIdx = " + this.currBlkIdx);
    }
    if (this.inStream == null)
        throw new IOException("reading from an output buffer");
    this.currRecIdx = 0;
    int offset = 0;
    int bytesNeeded = this.blockSize;
    for (; bytesNeeded > 0; ) {
        long numBytes = this.inStream.read(this.blockBuffer, offset, bytesNeeded);
        if (numBytes == -1)
            break;
        offset += numBytes;
        bytesNeeded -= numBytes;
        if (numBytes != this.blockSize) {
            if (this.debug) {
                System.err.println("ReadBlock: INCOMPLETE READ " + numBytes + " of " + this.blockSize + " bytes read.");
            }
        }
    }
    this.currBlkIdx++;
    return true;
}