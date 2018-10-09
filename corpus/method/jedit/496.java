public  TarBuffer(InputStream inStream, int blockSize, int recordSize) {
    this.inStream = inStream;
    this.outStream = null;
    this.initialize(blockSize, recordSize);
}