public  TarInputStream(InputStream is, int blockSize, int recordSize) {
    super(is);
    this.buffer = new TarBuffer(is, blockSize, recordSize);
    this.readBuf = null;
    this.oneBuf = new byte[1];
    this.debug = false;
    this.hasHitEOF = false;
    this.eFactory = null;
}