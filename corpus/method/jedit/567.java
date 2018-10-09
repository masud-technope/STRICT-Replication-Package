public  TarOutputStream(OutputStream os, int blockSize) {
    this(os, blockSize, TarBuffer.DEFAULT_RCDSIZE);
}