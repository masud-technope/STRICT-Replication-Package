private void sendMTFValues() throws IOException {
    char[][] len = new char[N_GROUPS][MAX_ALPHA_SIZE];
    int v;
    int t;
    int i;
    int j;
    int gs;
    int ge;
    int bt;
    int bc;
    int iter;
    int nSelectors = 0;
    int alphaSize;
    int minLen;
    int maxLen;
    int selCtr;
    int nGroups;
    alphaSize = m_nInUse + 2;
    for (t = 0; t < N_GROUPS; t++) {
        for (v = 0; v < alphaSize; v++) {
            len[t][v] = (char) GREATER_ICOST;
        }
    }
    /*
         * Decide how many coding tables to use
         */
    if (m_nMTF <= 0) {
        panic();
    }
    if (m_nMTF < 200) {
        nGroups = 2;
    } else if (m_nMTF < 600) {
        nGroups = 3;
    } else if (m_nMTF < 1200) {
        nGroups = 4;
    } else if (m_nMTF < 2400) {
        nGroups = 5;
    } else {
        nGroups = 6;
    }
    {
        /*
             * Generate an initial set of coding tables
             */
        int nPart;
        int remF;
        int tFreq;
        int aFreq;
        nPart = nGroups;
        remF = m_nMTF;
        gs = 0;
        while (nPart > 0) {
            tFreq = remF / nPart;
            ge = gs - 1;
            aFreq = 0;
            while (aFreq < tFreq && ge < alphaSize - 1) {
                ge++;
                aFreq += m_mtfFreq[ge];
            }
            if (ge > gs && nPart != nGroups && nPart != 1 && ((nGroups - nPart) % 2 == 1)) {
                aFreq -= m_mtfFreq[ge];
                ge--;
            }
            for (v = 0; v < alphaSize; v++) {
                if (v >= gs && v <= ge) {
                    len[nPart - 1][v] = (char) LESSER_ICOST;
                } else {
                    len[nPart - 1][v] = (char) GREATER_ICOST;
                }
            }
            nPart--;
            gs = ge + 1;
            remF -= aFreq;
        }
    }
    int[][] rfreq = new int[N_GROUPS][MAX_ALPHA_SIZE];
    int[] fave = new int[N_GROUPS];
    short[] cost = new short[N_GROUPS];
    /*
         * Iterate up to N_ITERS times to improve the tables.
         */
    for (iter = 0; iter < N_ITERS; iter++) {
        for (t = 0; t < nGroups; t++) {
            fave[t] = 0;
        }
        for (t = 0; t < nGroups; t++) {
            for (v = 0; v < alphaSize; v++) {
                rfreq[t][v] = 0;
            }
        }
        nSelectors = 0;
        gs = 0;
        while (true) {
            /*
                 * Set group start & end marks.
                 */
            if (gs >= m_nMTF) {
                break;
            }
            ge = gs + G_SIZE - 1;
            if (ge >= m_nMTF) {
                ge = m_nMTF - 1;
            }
            /*
                 * Calculate the cost of this group as coded
                 * by each of the coding tables.
                 */
            for (t = 0; t < nGroups; t++) {
                cost[t] = 0;
            }
            if (nGroups == 6) {
                short cost0 = 0;
                short cost1 = 0;
                short cost2 = 0;
                short cost3 = 0;
                short cost4 = 0;
                short cost5 = 0;
                for (i = gs; i <= ge; i++) {
                    short icv = m_szptr[i];
                    cost0 += len[0][icv];
                    cost1 += len[1][icv];
                    cost2 += len[2][icv];
                    cost3 += len[3][icv];
                    cost4 += len[4][icv];
                    cost5 += len[5][icv];
                }
                cost[0] = cost0;
                cost[1] = cost1;
                cost[2] = cost2;
                cost[3] = cost3;
                cost[4] = cost4;
                cost[5] = cost5;
            } else {
                for (i = gs; i <= ge; i++) {
                    short icv = m_szptr[i];
                    for (t = 0; t < nGroups; t++) {
                        cost[t] += len[t][icv];
                    }
                }
            }
            /*
                 * Find the coding table which is best for this group,
                 * and record its identity in the selector table.
                 */
            bc = 999999999;
            bt = -1;
            for (t = 0; t < nGroups; t++) {
                if (cost[t] < bc) {
                    bc = cost[t];
                    bt = t;
                }
            }
            ;
            fave[bt]++;
            m_selector[nSelectors] = (char) bt;
            nSelectors++;
            /*
                 * Increment the symbol frequencies for the selected table.
                 */
            for (i = gs; i <= ge; i++) {
                rfreq[bt][m_szptr[i]]++;
            }
            gs = ge + 1;
        }
        /*
             * Recompute the tables based on the accumulated frequencies.
             */
        for (t = 0; t < nGroups; t++) {
            hbMakeCodeLengths(len[t], rfreq[t], alphaSize, 20);
        }
    }
    rfreq = null;
    fave = null;
    cost = null;
    if (!(nGroups < 8)) {
        panic();
    }
    if (!(nSelectors < 32768 && nSelectors <= (2 + (900000 / G_SIZE)))) {
        panic();
    }
    {
        /*
             * Compute MTF values for the selectors.
             */
        char[] pos = new char[N_GROUPS];
        char ll_i;
        char tmp2;
        char tmp;
        for (i = 0; i < nGroups; i++) {
            pos[i] = (char) i;
        }
        for (i = 0; i < nSelectors; i++) {
            ll_i = m_selector[i];
            j = 0;
            tmp = pos[j];
            while (ll_i != tmp) {
                j++;
                tmp2 = tmp;
                tmp = pos[j];
                pos[j] = tmp2;
            }
            pos[0] = tmp;
            m_selectorMtf[i] = (char) j;
        }
    }
    int[][] code = new int[N_GROUPS][MAX_ALPHA_SIZE];
    /*
         * Assign actual codes for the tables.
         */
    for (t = 0; t < nGroups; t++) {
        minLen = 32;
        maxLen = 0;
        for (i = 0; i < alphaSize; i++) {
            if (len[t][i] > maxLen) {
                maxLen = len[t][i];
            }
            if (len[t][i] < minLen) {
                minLen = len[t][i];
            }
        }
        if (maxLen > 20) {
            panic();
        }
        if (minLen < 1) {
            panic();
        }
        hbAssignCodes(code[t], len[t], minLen, maxLen, alphaSize);
    }
    {
        /*
             * Transmit the mapping table.
             */
        boolean[] inUse16 = new boolean[16];
        for (i = 0; i < 16; i++) {
            inUse16[i] = false;
            for (j = 0; j < 16; j++) {
                if (m_inUse[i * 16 + j]) {
                    inUse16[i] = true;
                }
            }
        }
        for (i = 0; i < 16; i++) {
            if (inUse16[i]) {
                bsW(1, 1);
            } else {
                bsW(1, 0);
            }
        }
        for (i = 0; i < 16; i++) {
            if (inUse16[i]) {
                for (j = 0; j < 16; j++) {
                    if (m_inUse[i * 16 + j]) {
                        bsW(1, 1);
                    } else {
                        bsW(1, 0);
                    }
                }
            }
        }
    }
    /*
         * Now the selectors.
         */
    bsW(3, nGroups);
    bsW(15, nSelectors);
    for (i = 0; i < nSelectors; i++) {
        for (j = 0; j < m_selectorMtf[i]; j++) {
            bsW(1, 1);
        }
        bsW(1, 0);
    }
    for (t = 0; t < nGroups; t++) {
        int curr = len[t][0];
        bsW(5, curr);
        for (i = 0; i < alphaSize; i++) {
            while (curr < len[t][i]) {
                bsW(2, 2);
                curr++;
            /*
                     * 10
                     */
            }
            while (curr > len[t][i]) {
                bsW(2, 3);
                curr--;
            /*
                     * 11
                     */
            }
            bsW(1, 0);
        }
    }
    /*
         * And finally, the block data proper
         */
    selCtr = 0;
    gs = 0;
    while (true) {
        if (gs >= m_nMTF) {
            break;
        }
        ge = gs + G_SIZE - 1;
        if (ge >= m_nMTF) {
            ge = m_nMTF - 1;
        }
        for (i = gs; i <= ge; i++) {
            bsW(len[m_selector[selCtr]][m_szptr[i]], code[m_selector[selCtr]][m_szptr[i]]);
        }
        gs = ge + 1;
        selCtr++;
    }
    if (!(selCtr == nSelectors)) {
        panic();
    }
}