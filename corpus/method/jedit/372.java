private void qSort3(int loSt, int hiSt, int dSt) {
    int unLo;
    int unHi;
    int ltLo;
    int gtHi;
    int med;
    int n;
    int m;
    int sp;
    int lo;
    int hi;
    int d;
    StackElem[] stack = new StackElem[QSORT_STACK_SIZE];
    for (int count = 0; count < QSORT_STACK_SIZE; count++) {
        stack[count] = new StackElem();
    }
    sp = 0;
    stack[sp].m_ll = loSt;
    stack[sp].m_hh = hiSt;
    stack[sp].m_dd = dSt;
    sp++;
    while (sp > 0) {
        if (sp >= QSORT_STACK_SIZE) {
            panic();
        }
        sp--;
        lo = stack[sp].m_ll;
        hi = stack[sp].m_hh;
        d = stack[sp].m_dd;
        if (hi - lo < SMALL_THRESH || d > DEPTH_THRESH) {
            simpleSort(lo, hi, d);
            if (m_workDone > m_workLimit && m_firstAttempt) {
                return;
            }
            continue;
        }
        med = med3(m_block[m_zptr[lo] + d + 1], m_block[m_zptr[hi] + d + 1], m_block[m_zptr[(lo + hi) >> 1] + d + 1]);
        unLo = lo;
        ltLo = lo;
        unHi = hi;
        gtHi = hi;
        while (true) {
            while (true) {
                if (unLo > unHi) {
                    break;
                }
                n = m_block[m_zptr[unLo] + d + 1] - med;
                if (n == 0) {
                    int temp = 0;
                    temp = m_zptr[unLo];
                    m_zptr[unLo] = m_zptr[ltLo];
                    m_zptr[ltLo] = temp;
                    ltLo++;
                    unLo++;
                    continue;
                }
                ;
                if (n > 0) {
                    break;
                }
                unLo++;
            }
            while (true) {
                if (unLo > unHi) {
                    break;
                }
                n = m_block[m_zptr[unHi] + d + 1] - med;
                if (n == 0) {
                    int temp = 0;
                    temp = m_zptr[unHi];
                    m_zptr[unHi] = m_zptr[gtHi];
                    m_zptr[gtHi] = temp;
                    gtHi--;
                    unHi--;
                    continue;
                }
                ;
                if (n < 0) {
                    break;
                }
                unHi--;
            }
            if (unLo > unHi) {
                break;
            }
            int temp = 0;
            temp = m_zptr[unLo];
            m_zptr[unLo] = m_zptr[unHi];
            m_zptr[unHi] = temp;
            unLo++;
            unHi--;
        }
        if (gtHi < ltLo) {
            stack[sp].m_ll = lo;
            stack[sp].m_hh = hi;
            stack[sp].m_dd = d + 1;
            sp++;
            continue;
        }
        n = ((ltLo - lo) < (unLo - ltLo)) ? (ltLo - lo) : (unLo - ltLo);
        vswap(lo, unLo - n, n);
        m = ((hi - gtHi) < (gtHi - unHi)) ? (hi - gtHi) : (gtHi - unHi);
        vswap(unLo, hi - m + 1, m);
        n = lo + unLo - ltLo - 1;
        m = hi - (gtHi - unHi) + 1;
        stack[sp].m_ll = lo;
        stack[sp].m_hh = n;
        stack[sp].m_dd = d;
        sp++;
        stack[sp].m_ll = n + 1;
        stack[sp].m_hh = m - 1;
        stack[sp].m_dd = d + 1;
        sp++;
        stack[sp].m_ll = m;
        stack[sp].m_hh = hi;
        stack[sp].m_dd = d;
        sp++;
    }
}