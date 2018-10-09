void updateCRC(final int inCh) {
    int temp = (m_globalCrc >> 24) ^ inCh;
    if (temp < 0) {
        temp = 256 + temp;
    }
    m_globalCrc = (m_globalCrc << 8) ^ CRC32_TABLE[temp];
}