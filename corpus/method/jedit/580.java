public  TarOutputStream(OutputStream os) {
    this(os, TarBuffer.DEFAULT_BLKSIZE, TarBuffer.DEFAULT_RCDSIZE);
}