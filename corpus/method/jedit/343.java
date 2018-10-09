private void setDecompressStructureSizes(int newSize100k) {
    if (!(0 <= newSize100k && newSize100k <= 9 && 0 <= m_blockSize100k && m_blockSize100k <= 9)) {
    // throw new IOException("Invalid block size");
    }
    m_blockSize100k = newSize100k;
    if (newSize100k == 0) {
        return;
    }
    int n = BASE_BLOCK_SIZE * newSize100k;
    m_ll8 = new char[n];
    m_tt = new int[n];
}