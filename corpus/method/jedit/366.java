private void bsFinishedWithStream() throws IOException {
    while (m_bsLive > 0) {
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
}