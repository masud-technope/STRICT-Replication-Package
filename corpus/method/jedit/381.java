private void initBlock() {
    //        blockNo++;
    m_crc.initialiseCRC();
    m_last = -1;
    for (int i = 0; i < 256; i++) {
        m_inUse[i] = false;
    }
    /*
         * 20 is just a paranoia constant
         */
    m_allowableBlockSize = BASE_BLOCK_SIZE * m_blockSize100k - 20;
}