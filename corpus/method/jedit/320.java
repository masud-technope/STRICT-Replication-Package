private void initBlock() {
    final char magic1 = readUnsignedChar();
    final char magic2 = readUnsignedChar();
    final char magic3 = readUnsignedChar();
    final char magic4 = readUnsignedChar();
    final char magic5 = readUnsignedChar();
    final char magic6 = readUnsignedChar();
    if (magic1 == 0x17 && magic2 == 0x72 && magic3 == 0x45 && magic4 == 0x38 && magic5 == 0x50 && magic6 == 0x90) {
        complete();
        return;
    }
    if (magic1 != 0x31 || magic2 != 0x41 || magic3 != 0x59 || magic4 != 0x26 || magic5 != 0x53 || magic6 != 0x59) {
        badBlockHeader();
        m_streamEnd = true;
        return;
    }
    m_storedBlockCRC = readInt();
    if (bsR(1) == 1) {
        m_blockRandomised = true;
    } else {
        m_blockRandomised = false;
    }
    //        currBlockNo++;
    getAndMoveToFrontDecode();
    m_crc.initialiseCRC();
    m_currentState = START_BLOCK_STATE;
}