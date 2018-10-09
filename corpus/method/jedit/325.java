private void complete() {
    m_storedCombinedCRC = readInt();
    if (m_storedCombinedCRC != m_computedCombinedCRC) {
        crcError();
    }
    bsFinishedWithStream();
    m_streamEnd = true;
}