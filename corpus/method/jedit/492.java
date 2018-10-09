/**
	 * Initialization common to all constructors.
	 */
private void initialize(int blockSize, int recordSize) {
    this.debug = false;
    this.blockSize = blockSize;
    this.recordSize = recordSize;
    this.recsPerBlock = (this.blockSize / this.recordSize);
    this.blockBuffer = new byte[this.blockSize];
    if (this.inStream != null) {
        this.currBlkIdx = -1;
        this.currRecIdx = this.recsPerBlock;
    } else {
        this.currBlkIdx = 0;
        this.currRecIdx = 0;
    }
}