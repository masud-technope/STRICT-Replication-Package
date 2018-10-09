private void simpleSort(int lo, int hi, int d) {
    int i;
    int j;
    int h;
    int bigN;
    int hp;
    int v;
    bigN = hi - lo + 1;
    if (bigN < 2) {
        return;
    }
    hp = 0;
    while (m_incs[hp] < bigN) {
        hp++;
    }
    hp--;
    for (; hp >= 0; hp--) {
        h = m_incs[hp];
        i = lo + h;
        while (true) {
            /*
                 * copy 1
                 */
            if (i > hi) {
                break;
            }
            v = m_zptr[i];
            j = i;
            while (fullGtU(m_zptr[j - h] + d, v + d)) {
                m_zptr[j] = m_zptr[j - h];
                j = j - h;
                if (j <= (lo + h - 1)) {
                    break;
                }
            }
            m_zptr[j] = v;
            i++;
            /*
                 * copy 2
                 */
            if (i > hi) {
                break;
            }
            v = m_zptr[i];
            j = i;
            while (fullGtU(m_zptr[j - h] + d, v + d)) {
                m_zptr[j] = m_zptr[j - h];
                j = j - h;
                if (j <= (lo + h - 1)) {
                    break;
                }
            }
            m_zptr[j] = v;
            i++;
            /*
                 * copy 3
                 */
            if (i > hi) {
                break;
            }
            v = m_zptr[i];
            j = i;
            while (fullGtU(m_zptr[j - h] + d, v + d)) {
                m_zptr[j] = m_zptr[j - h];
                j = j - h;
                if (j <= (lo + h - 1)) {
                    break;
                }
            }
            m_zptr[j] = v;
            i++;
            if (m_workDone > m_workLimit && m_firstAttempt) {
                return;
            }
        }
    }
}