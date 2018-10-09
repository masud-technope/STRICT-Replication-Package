public void close() throws IOException {
    if (m_closed) {
        return;
    }
    if (m_runLength > 0) {
        writeRun();
    }
    m_currentChar = -1;
    endBlock();
    endCompression();
    m_closed = true;
    super.close();
    m_bsStream.close();
}