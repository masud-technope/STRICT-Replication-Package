private void setupRandPartA() {
    if (i2 <= m_last) {
        chPrev = ch2;
        ch2 = m_ll8[m_tPos];
        m_tPos = m_tt[m_tPos];
        if (m_rNToGo == 0) {
            m_rNToGo = RAND_NUMS[m_rTPos];
            m_rTPos++;
            if (m_rTPos == 512) {
                m_rTPos = 0;
            }
        }
        m_rNToGo--;
        ch2 ^= ((m_rNToGo == 1) ? 1 : 0);
        i2++;
        m_currentChar = ch2;
        m_currentState = RAND_PART_B_STATE;
        m_crc.updateCRC(ch2);
    } else {
        endBlock();
        initBlock();
        setupBlock();
    }
}