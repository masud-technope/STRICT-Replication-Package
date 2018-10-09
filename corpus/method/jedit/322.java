private void endBlock() {
    m_computedBlockCRC = m_crc.getFinalCRC();
    /*
         * A bad CRC is considered a fatal error.
         */
    if (m_storedBlockCRC != m_computedBlockCRC) {
        crcError();
    }
    m_computedCombinedCRC = (m_computedCombinedCRC << 1) | (m_computedCombinedCRC >>> 31);
    m_computedCombinedCRC ^= m_computedBlockCRC;
}