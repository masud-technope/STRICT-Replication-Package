public TarEntry createEntry(byte[] headerBuf) throws InvalidHeaderException {
    return new TarEntry(headerBuf);
}