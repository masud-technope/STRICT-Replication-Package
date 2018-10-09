private void setupRandPartB() {
    if (ch2 != chPrev) {
        m_currentState = RAND_PART_A_STATE;
        count = 1;
        setupRandPartA();
    } else {
        count++;
        if (count >= 4) {
            z = m_ll8[m_tPos];
            m_tPos = m_tt[m_tPos];
            if (m_rNToGo == 0) {
                m_rNToGo = RAND_NUMS[m_rTPos];
                m_rTPos++;
                if (m_rTPos == 512) {
                    m_rTPos = 0;
                }
            }
            m_rNToGo--;
            z ^= ((m_rNToGo == 1) ? 1 : 0);
            j2 = 0;
            m_currentState = RAND_PART_C_STATE;
            setupRandPartC();
        } else {
            m_currentState = RAND_PART_A_STATE;
            setupRandPartA();
        }
    }
}