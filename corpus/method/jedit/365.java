private void bsW(int n, int v) throws IOException {
    while (m_bsLive >= 8) {
        int ch = (m_bsBuff >> 24);
        try {
            // write 8-bit
            m_bsStream.write(ch);
        } catch (IOException e) {
            throw e;
        }
        m_bsBuff <<= 8;
        m_bsLive -= 8;
    }
    m_bsBuff |= (v << (32 - m_bsLive - n));
    m_bsLive += n;
}