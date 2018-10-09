private void initialize() throws IOException {
    /*
         * Write `magic' bytes h indicating file-format == huffmanised,
         * followed by a digit indicating blockSize100k.
         */
    bsPutUChar('h');
    bsPutUChar('0' + m_blockSize100k);
    m_combinedCRC = 0;
}