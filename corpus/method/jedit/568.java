public  TarOutputStream(OutputStream os, int blockSize, int recordSize) {
    super(os);
    this.buffer = new TarBuffer(os, blockSize, recordSize);
    this.debug = false;
    this.assemLen = 0;
    this.assemBuf = new byte[recordSize];
    this.recordBuf = new byte[recordSize];
    this.oneBuf = new byte[1];
}