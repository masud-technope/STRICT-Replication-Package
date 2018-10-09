private void recvDecodingTables() {
    buildInUseTable();
    makeMaps();
    final int alphaSize = m_nInUse + 2;
    /*
         * Now the selectors
         */
    final int groupCount = bsR(3);
    final int selectorCount = bsR(15);
    for (int i = 0; i < selectorCount; i++) {
        int run = 0;
        while (bsR(1) == 1) {
            run++;
        }
        m_selectorMtf[i] = (char) run;
    }
    /*
         * Undo the MTF values for the selectors.
         */
    final char[] pos = new char[N_GROUPS];
    for (char v = 0; v < groupCount; v++) {
        pos[v] = v;
    }
    for (int i = 0; i < selectorCount; i++) {
        int v = m_selectorMtf[i];
        final char tmp = pos[v];
        while (v > 0) {
            pos[v] = pos[v - 1];
            v--;
        }
        pos[0] = tmp;
        m_selector[i] = tmp;
    }
    final char[][] len = new char[N_GROUPS][MAX_ALPHA_SIZE];
    /*
         * Now the coding tables
         */
    for (int i = 0; i < groupCount; i++) {
        int curr = bsR(5);
        for (int j = 0; j < alphaSize; j++) {
            while (bsR(1) == 1) {
                if (bsR(1) == 0) {
                    curr++;
                } else {
                    curr--;
                }
            }
            len[i][j] = (char) curr;
        }
    }
    /*
         * Create the Huffman decoding tables
         */
    for (int k = 0; k < groupCount; k++) {
        int minLen = 32;
        int maxLen = 0;
        for (int i = 0; i < alphaSize; i++) {
            if (len[k][i] > maxLen) {
                maxLen = len[k][i];
            }
            if (len[k][i] < minLen) {
                minLen = len[k][i];
            }
        }
        hbCreateDecodeTables(m_limit[k], m_base[k], m_perm[k], len[k], minLen, maxLen, alphaSize);
        m_minLens[k] = minLen;
    }
}