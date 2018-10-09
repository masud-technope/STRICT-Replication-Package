private void makeMaps() {
    int i;
    m_nInUse = 0;
    for (i = 0; i < 256; i++) {
        if (m_inUse[i]) {
            m_seqToUnseq[m_nInUse] = (char) i;
            m_unseqToSeq[i] = (char) m_nInUse;
            m_nInUse++;
        }
    }
}