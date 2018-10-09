/**
     * modified by Oliver Merkel, 010128
     *
     * @param bv Description of Parameter
     * @exception java.io.IOException Description of Exception
     */
public void write(int bv) throws IOException {
    int b = (256 + bv) % 256;
    if (m_currentChar != -1) {
        if (m_currentChar == b) {
            m_runLength++;
            if (m_runLength > 254) {
                writeRun();
                m_currentChar = -1;
                m_runLength = 0;
            }
        } else {
            writeRun();
            m_runLength = 1;
            m_currentChar = b;
        }
    } else {
        m_currentChar = b;
        m_runLength++;
    }
}