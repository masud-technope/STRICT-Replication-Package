private int bsR(final int n) {
    while (m_bsLive < n) {
        char ch = 0;
        try {
            ch = (char) m_input.read();
        } catch (final IOException ioe) {
            compressedStreamEOF();
        }
        if (ch == -1) {
            compressedStreamEOF();
        }
        m_bsBuff = (m_bsBuff << 8) | (ch & 0xff);
        m_bsLive += 8;
    }
    final int result = (m_bsBuff >> (m_bsLive - n)) & ((1 << n) - 1);
    m_bsLive -= n;
    return result;
}