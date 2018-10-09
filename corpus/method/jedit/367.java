private void allocateCompressStructures() {
    int n = BASE_BLOCK_SIZE * m_blockSize100k;
    m_block = new char[(n + 1 + NUM_OVERSHOOT_BYTES)];
    m_quadrant = new int[(n + NUM_OVERSHOOT_BYTES)];
    m_zptr = new int[n];
    m_ftab = new int[65537];
    if (m_block == null || m_quadrant == null || m_zptr == null || m_ftab == null) {
    //int totalDraw = (n + 1 + NUM_OVERSHOOT_BYTES) + (n + NUM_OVERSHOOT_BYTES) + n + 65537;
    //compressOutOfMemory ( totalDraw, n );
    }
    /*
         * The back end needs a place to store the MTF values
         * whilst it calculates the coding tables.  We could
         * put them in the zptr array.  However, these values
         * will fit in a short, so we overlay szptr at the
         * start of zptr, in the hope of reducing the number
         * of cache misses induced by the multiple traversals
         * of the MTF values when calculating coding tables.
         * Seems to improve compression speed by about 1%.
         */
    //    szptr = zptr;
    m_szptr = new short[2 * n];
}