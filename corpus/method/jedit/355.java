public  CBZip2OutputStream(final OutputStream output, final int blockSize) throws IOException {
    bsSetStream(output);
    m_workFactor = 50;
    int outBlockSize = blockSize;
    if (outBlockSize > 9) {
        outBlockSize = 9;
    }
    if (outBlockSize < 1) {
        outBlockSize = 1;
    }
    m_blockSize100k = outBlockSize;
    allocateCompressStructures();
    initialize();
    initBlock();
}