public  TarInputStream(InputStream is) {
    this(is, TarBuffer.DEFAULT_BLKSIZE, TarBuffer.DEFAULT_RCDSIZE);
}