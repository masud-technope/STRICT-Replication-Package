public  TarBuffer(InputStream inStream, int blockSize) {
    this(inStream, blockSize, TarBuffer.DEFAULT_RCDSIZE);
}