private void writeRun() throws IOException {
    if (m_last < m_allowableBlockSize) {
        m_inUse[m_currentChar] = true;
        for (int i = 0; i < m_runLength; i++) {
            m_crc.updateCRC((char) m_currentChar);
        }
        switch(m_runLength) {
            case 1:
                m_last++;
                m_block[m_last + 1] = (char) m_currentChar;
                break;
            case 2:
                m_last++;
                m_block[m_last + 1] = (char) m_currentChar;
                m_last++;
                m_block[m_last + 1] = (char) m_currentChar;
                break;
            case 3:
                m_last++;
                m_block[m_last + 1] = (char) m_currentChar;
                m_last++;
                m_block[m_last + 1] = (char) m_currentChar;
                m_last++;
                m_block[m_last + 1] = (char) m_currentChar;
                break;
            default:
                m_inUse[m_runLength - 4] = true;
                m_last++;
                m_block[m_last + 1] = (char) m_currentChar;
                m_last++;
                m_block[m_last + 1] = (char) m_currentChar;
                m_last++;
                m_block[m_last + 1] = (char) m_currentChar;
                m_last++;
                m_block[m_last + 1] = (char) m_currentChar;
                m_last++;
                m_block[m_last + 1] = (char) (m_runLength - 4);
                break;
        }
    } else {
        endBlock();
        initBlock();
        writeRun();
    }
}