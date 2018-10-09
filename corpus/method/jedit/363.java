private void endBlock() throws IOException {
    m_blockCRC = m_crc.getFinalCRC();
    m_combinedCRC = (m_combinedCRC << 1) | (m_combinedCRC >>> 31);
    m_combinedCRC ^= m_blockCRC;
    /*
         * sort the block and establish posn of original string
         */
    doReversibleTransformation();
    /*
         * A 6-byte block header, the value chosen arbitrarily
         * as 0x314159265359 :-).  A 32 bit value does not really
         * give a strong enough guarantee that the value will not
         * appear by chance in the compressed datastream.  Worst-case
         * probability of this event, for a 900k block, is about
         * 2.0e-3 for 32 bits, 1.0e-5 for 40 bits and 4.0e-8 for 48 bits.
         * For a compressed file of size 100Gb -- about 100000 blocks --
         * only a 48-bit marker will do.  NB: normal compression/
         * decompression do *not* rely on these statistical properties.
         * They are only important when trying to recover blocks from
         * damaged files.
         */
    bsPutUChar(0x31);
    bsPutUChar(0x41);
    bsPutUChar(0x59);
    bsPutUChar(0x26);
    bsPutUChar(0x53);
    bsPutUChar(0x59);
    /*
         * Now the block's CRC, so it is in a known place.
         */
    bsPutint(m_blockCRC);
    /*
         * Now a single bit indicating randomisation.
         */
    if (m_blockRandomised) {
        bsW(1, 1);
    } else {
        bsW(1, 0);
    }
    /*
         * Finally, block's contents proper.
         */
    moveToFrontCodeAndSend();
}