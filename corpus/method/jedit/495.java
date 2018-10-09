public  TarBuffer(OutputStream outStream, int blockSize, int recordSize) {
    this.inStream = null;
    this.outStream = outStream;
    this.initialize(blockSize, recordSize);
}