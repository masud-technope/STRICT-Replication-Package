private void setupBlock() {
    int[] cftab = new int[257];
    char ch;
    cftab[0] = 0;
    for (int i = 1; i <= 256; i++) {
        cftab[i] = m_unzftab[i - 1];
    }
    for (int i = 1; i <= 256; i++) {
        cftab[i] += cftab[i - 1];
    }
    for (int i = 0; i <= m_last; i++) {
        ch = m_ll8[i];
        m_tt[cftab[ch]] = i;
        cftab[ch]++;
    }
    cftab = null;
    m_tPos = m_tt[m_origPtr];
    count = 0;
    i2 = 0;
    ch2 = 256;
    /*
         * not a char and not EOF
         */
    if (m_blockRandomised) {
        m_rNToGo = 0;
        m_rTPos = 0;
        setupRandPartA();
    } else {
        setupNoRandPartA();
    }
}