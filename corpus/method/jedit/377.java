private boolean fullGtU(int i1, int i2) {
    int k;
    char c1;
    char c2;
    int s1;
    int s2;
    c1 = m_block[i1 + 1];
    c2 = m_block[i2 + 1];
    if (c1 != c2) {
        return (c1 > c2);
    }
    i1++;
    i2++;
    c1 = m_block[i1 + 1];
    c2 = m_block[i2 + 1];
    if (c1 != c2) {
        return (c1 > c2);
    }
    i1++;
    i2++;
    c1 = m_block[i1 + 1];
    c2 = m_block[i2 + 1];
    if (c1 != c2) {
        return (c1 > c2);
    }
    i1++;
    i2++;
    c1 = m_block[i1 + 1];
    c2 = m_block[i2 + 1];
    if (c1 != c2) {
        return (c1 > c2);
    }
    i1++;
    i2++;
    c1 = m_block[i1 + 1];
    c2 = m_block[i2 + 1];
    if (c1 != c2) {
        return (c1 > c2);
    }
    i1++;
    i2++;
    c1 = m_block[i1 + 1];
    c2 = m_block[i2 + 1];
    if (c1 != c2) {
        return (c1 > c2);
    }
    i1++;
    i2++;
    k = m_last + 1;
    do {
        c1 = m_block[i1 + 1];
        c2 = m_block[i2 + 1];
        if (c1 != c2) {
            return (c1 > c2);
        }
        s1 = m_quadrant[i1];
        s2 = m_quadrant[i2];
        if (s1 != s2) {
            return (s1 > s2);
        }
        i1++;
        i2++;
        c1 = m_block[i1 + 1];
        c2 = m_block[i2 + 1];
        if (c1 != c2) {
            return (c1 > c2);
        }
        s1 = m_quadrant[i1];
        s2 = m_quadrant[i2];
        if (s1 != s2) {
            return (s1 > s2);
        }
        i1++;
        i2++;
        c1 = m_block[i1 + 1];
        c2 = m_block[i2 + 1];
        if (c1 != c2) {
            return (c1 > c2);
        }
        s1 = m_quadrant[i1];
        s2 = m_quadrant[i2];
        if (s1 != s2) {
            return (s1 > s2);
        }
        i1++;
        i2++;
        c1 = m_block[i1 + 1];
        c2 = m_block[i2 + 1];
        if (c1 != c2) {
            return (c1 > c2);
        }
        s1 = m_quadrant[i1];
        s2 = m_quadrant[i2];
        if (s1 != s2) {
            return (s1 > s2);
        }
        i1++;
        i2++;
        if (i1 > m_last) {
            i1 -= m_last;
            i1--;
        }
        ;
        if (i2 > m_last) {
            i2 -= m_last;
            i2--;
        }
        ;
        k -= 4;
        m_workDone++;
    } while (k >= 0);
    return false;
}