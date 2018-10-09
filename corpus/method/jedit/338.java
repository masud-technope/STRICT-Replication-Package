private void setupNoRandPartA() {
    if (i2 <= m_last) {
        chPrev = ch2;
        ch2 = m_ll8[m_tPos];
        m_tPos = m_tt[m_tPos];
        i2++;
        m_currentChar = ch2;
        m_currentState = NO_RAND_PART_B_STATE;
        m_crc.updateCRC(ch2);
    } else {
        endBlock();
        initBlock();
        setupBlock();
    }
}