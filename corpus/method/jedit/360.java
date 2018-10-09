private void randomiseBlock() {
    int i;
    int rNToGo = 0;
    int rTPos = 0;
    for (i = 0; i < 256; i++) {
        m_inUse[i] = false;
    }
    for (i = 0; i <= m_last; i++) {
        if (rNToGo == 0) {
            rNToGo = (char) RAND_NUMS[rTPos];
            rTPos++;
            if (rTPos == 512) {
                rTPos = 0;
            }
        }
        rNToGo--;
        m_block[i + 1] ^= ((rNToGo == 1) ? 1 : 0);
        // handle 16 bit signed numbers
        m_block[i + 1] &= 0xFF;
        m_inUse[m_block[i + 1]] = true;
    }
}