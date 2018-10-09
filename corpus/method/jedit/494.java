public  TarBuffer(OutputStream outStream, int blockSize) {
    this(outStream, blockSize, TarBuffer.DEFAULT_RCDSIZE);
}