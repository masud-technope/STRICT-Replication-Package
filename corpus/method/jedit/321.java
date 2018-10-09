private void initialize() {
    final char magic3 = readUnsignedChar();
    final char magic4 = readUnsignedChar();
    if (magic3 != 'h' || magic4 < '1' || magic4 > '9') {
        bsFinishedWithStream();
        m_streamEnd = true;
        return;
    }
    setDecompressStructureSizes(magic4 - '0');
    m_computedCombinedCRC = 0;
}