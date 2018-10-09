private void setupNoRandPartB() {
    if (ch2 != chPrev) {
        m_currentState = NO_RAND_PART_A_STATE;
        count = 1;
        setupNoRandPartA();
    } else {
        count++;
        if (count >= 4) {
            z = m_ll8[m_tPos];
            m_tPos = m_tt[m_tPos];
            m_currentState = NO_RAND_PART_C_STATE;
            j2 = 0;
            setupNoRandPartC();
        } else {
            m_currentState = NO_RAND_PART_A_STATE;
            setupNoRandPartA();
        }
    }
}