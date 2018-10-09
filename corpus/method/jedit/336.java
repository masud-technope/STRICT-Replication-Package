public  CBZip2InputStream(final InputStream input) {
    bsSetStream(input);
    initialize();
    initBlock();
    setupBlock();
}