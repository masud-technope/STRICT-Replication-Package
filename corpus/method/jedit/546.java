public  TarInputStream(InputStream is, int blockSize) {
    this(is, blockSize, TarBuffer.DEFAULT_RCDSIZE);
}