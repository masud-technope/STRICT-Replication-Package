private void endCompression() throws IOException {
    /*
         * Now another magic 48-bit number, 0x177245385090, to
         * indicate the end of the last block.  (sqrt(pi), if
         * you want to know.  I did want to use e, but it contains
         * too much repetition -- 27 18 28 18 28 46 -- for me
         * to feel statistically comfortable.  Call me paranoid.)
         */
    bsPutUChar(0x17);
    bsPutUChar(0x72);
    bsPutUChar(0x45);
    bsPutUChar(0x38);
    bsPutUChar(0x50);
    bsPutUChar(0x90);
    bsPutint(m_combinedCRC);
    bsFinishedWithStream();
}