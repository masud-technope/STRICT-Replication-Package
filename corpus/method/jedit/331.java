private void setupRandPartC() {
    if (j2 < z) {
        m_currentChar = ch2;
        m_crc.updateCRC(ch2);
        j2++;
    } else {
        m_currentState = RAND_PART_A_STATE;
        i2++;
        count = 0;
        setupRandPartA();
    }
}