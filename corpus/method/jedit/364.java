private void doReversibleTransformation() {
    int i;
    m_workLimit = m_workFactor * m_last;
    m_workDone = 0;
    m_blockRandomised = false;
    m_firstAttempt = true;
    mainSort();
    if (m_workDone > m_workLimit && m_firstAttempt) {
        randomiseBlock();
        m_workLimit = 0;
        m_workDone = 0;
        m_blockRandomised = true;
        m_firstAttempt = false;
        mainSort();
    }
    m_origPtr = -1;
    for (i = 0; i <= m_last; i++) {
        if (m_zptr[i] == 0) {
            m_origPtr = i;
            break;
        }
    }
    ;
    if (m_origPtr == -1) {
        panic();
    }
}