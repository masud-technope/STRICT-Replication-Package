private void getAndMoveToFrontDecode() {
    int nextSym;
    int limitLast = BASE_BLOCK_SIZE * m_blockSize100k;
    m_origPtr = readVariableSizedInt(24);
    recvDecodingTables();
    int EOB = m_nInUse + 1;
    int groupNo = -1;
    int groupPos = 0;
    /*
         * Setting up the unzftab entries here is not strictly
         * necessary, but it does save having to do it later
         * in a separate pass, and so saves a block's worth of
         * cache misses.
         */
    for (int i = 0; i <= 255; i++) {
        m_unzftab[i] = 0;
    }
    final char[] yy = new char[256];
    for (int i = 0; i <= 255; i++) {
        yy[i] = (char) i;
    }
    m_last = -1;
    int zt;
    int zn;
    int zvec;
    int zj;
    groupNo++;
    groupPos = G_SIZE - 1;
    zt = m_selector[groupNo];
    zn = m_minLens[zt];
    zvec = bsR(zn);
    while (zvec > m_limit[zt][zn]) {
        zn++;
        while (m_bsLive < 1) {
            int zzi;
            try {
                zzi = m_input.read();
            } catch (IOException e) {
                compressedStreamEOF();
                break;
            }
            if (zzi == -1) {
                compressedStreamEOF();
                break;
            }
            m_bsBuff = (m_bsBuff << 8) | (zzi & 0xff);
            m_bsLive += 8;
        }
        zj = (m_bsBuff >> (m_bsLive - 1)) & 1;
        m_bsLive--;
        zvec = (zvec << 1) | zj;
    }
    nextSym = m_perm[zt][zvec - m_base[zt][zn]];
    while (true) {
        if (nextSym == EOB) {
            break;
        }
        if (nextSym == RUNA || nextSym == RUNB) {
            char ch;
            int s = -1;
            int N = 1;
            do {
                if (nextSym == RUNA) {
                    s = s + (0 + 1) * N;
                } else // if( nextSym == RUNB )
                {
                    s = s + (1 + 1) * N;
                }
                N = N * 2;
                if (groupPos == 0) {
                    groupNo++;
                    groupPos = G_SIZE;
                }
                groupPos--;
                zt = m_selector[groupNo];
                zn = m_minLens[zt];
                zvec = bsR(zn);
                while (zvec > m_limit[zt][zn]) {
                    zn++;
                    while (m_bsLive < 1) {
                        int zzi;
                        char thech = 0;
                        try {
                            thech = (char) m_input.read();
                        } catch (IOException e) {
                            compressedStreamEOF();
                        }
                        if (thech == -1) {
                            compressedStreamEOF();
                        }
                        zzi = thech;
                        m_bsBuff = (m_bsBuff << 8) | (zzi & 0xff);
                        m_bsLive += 8;
                    }
                    zj = (m_bsBuff >> (m_bsLive - 1)) & 1;
                    m_bsLive--;
                    zvec = (zvec << 1) | zj;
                }
                nextSym = m_perm[zt][zvec - m_base[zt][zn]];
            } while (nextSym == RUNA || nextSym == RUNB);
            s++;
            ch = m_seqToUnseq[yy[0]];
            m_unzftab[ch] += s;
            while (s > 0) {
                m_last++;
                m_ll8[m_last] = ch;
                s--;
            }
            if (m_last >= limitLast) {
                blockOverrun();
            }
            continue;
        } else {
            char tmp;
            m_last++;
            if (m_last >= limitLast) {
                blockOverrun();
            }
            tmp = yy[nextSym - 1];
            m_unzftab[m_seqToUnseq[tmp]]++;
            m_ll8[m_last] = m_seqToUnseq[tmp];
            /*
                 * This loop is hammered during decompression,
                 * hence the unrolling.
                 * for (j = nextSym-1; j > 0; j--) yy[j] = yy[j-1];
                 */
            int j = nextSym - 1;
            for (; j > 3; j -= 4) {
                yy[j] = yy[j - 1];
                yy[j - 1] = yy[j - 2];
                yy[j - 2] = yy[j - 3];
                yy[j - 3] = yy[j - 4];
            }
            for (; j > 0; j--) {
                yy[j] = yy[j - 1];
            }
            yy[0] = tmp;
            if (groupPos == 0) {
                groupNo++;
                groupPos = G_SIZE;
            }
            groupPos--;
            zt = m_selector[groupNo];
            zn = m_minLens[zt];
            zvec = bsR(zn);
            while (zvec > m_limit[zt][zn]) {
                zn++;
                while (m_bsLive < 1) {
                    char ch = 0;
                    try {
                        ch = (char) m_input.read();
                    } catch (IOException e) {
                        compressedStreamEOF();
                    }
                    m_bsBuff = (m_bsBuff << 8) | (ch & 0xff);
                    m_bsLive += 8;
                }
                zj = (m_bsBuff >> (m_bsLive - 1)) & 1;
                m_bsLive--;
                zvec = (zvec << 1) | zj;
            }
            nextSym = m_perm[zt][zvec - m_base[zt][zn]];
            continue;
        }
    }
}