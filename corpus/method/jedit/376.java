private void generateMTFValues() {
    char[] yy = new char[256];
    int i;
    int j;
    char tmp;
    char tmp2;
    int zPend;
    int wr;
    int EOB;
    makeMaps();
    EOB = m_nInUse + 1;
    for (i = 0; i <= EOB; i++) {
        m_mtfFreq[i] = 0;
    }
    wr = 0;
    zPend = 0;
    for (i = 0; i < m_nInUse; i++) {
        yy[i] = (char) i;
    }
    for (i = 0; i <= m_last; i++) {
        char ll_i;
        ll_i = m_unseqToSeq[m_block[m_zptr[i]]];
        j = 0;
        tmp = yy[j];
        while (ll_i != tmp) {
            j++;
            tmp2 = tmp;
            tmp = yy[j];
            yy[j] = tmp2;
        }
        ;
        yy[0] = tmp;
        if (j == 0) {
            zPend++;
        } else {
            if (zPend > 0) {
                zPend--;
                while (true) {
                    switch(zPend % 2) {
                        case 0:
                            m_szptr[wr] = (short) RUNA;
                            wr++;
                            m_mtfFreq[RUNA]++;
                            break;
                        case 1:
                            m_szptr[wr] = (short) RUNB;
                            wr++;
                            m_mtfFreq[RUNB]++;
                            break;
                    }
                    ;
                    if (zPend < 2) {
                        break;
                    }
                    zPend = (zPend - 2) / 2;
                }
                ;
                zPend = 0;
            }
            m_szptr[wr] = (short) (j + 1);
            wr++;
            m_mtfFreq[j + 1]++;
        }
    }
    if (zPend > 0) {
        zPend--;
        while (true) {
            switch(zPend % 2) {
                case 0:
                    m_szptr[wr] = (short) RUNA;
                    wr++;
                    m_mtfFreq[RUNA]++;
                    break;
                case 1:
                    m_szptr[wr] = (short) RUNB;
                    wr++;
                    m_mtfFreq[RUNB]++;
                    break;
            }
            if (zPend < 2) {
                break;
            }
            zPend = (zPend - 2) / 2;
        }
    }
    m_szptr[wr] = (short) EOB;
    wr++;
    m_mtfFreq[EOB]++;
    m_nMTF = wr;
}