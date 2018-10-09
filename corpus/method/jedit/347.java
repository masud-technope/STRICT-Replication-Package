private void buildInUseTable() {
    final boolean[] inUse16 = new boolean[16];
    /*
         * Receive the mapping table
         */
    for (int i = 0; i < 16; i++) {
        if (bsR(1) == 1) {
            inUse16[i] = true;
        } else {
            inUse16[i] = false;
        }
    }
    for (int i = 0; i < 256; i++) {
        m_inUse[i] = false;
    }
    for (int i = 0; i < 16; i++) {
        if (inUse16[i]) {
            for (int j = 0; j < 16; j++) {
                if (bsR(1) == 1) {
                    m_inUse[i * 16 + j] = true;
                }
            }
        }
    }
}