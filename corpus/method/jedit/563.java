/**
	 * Get the next entry in this tar archive. This will skip
	 * over any remaining data in the current entry, if there
	 * is one, and place the input stream at the header of the
	 * next entry, and read the header and instantiate a new
	 * TarEntry from the header bytes and return that entry.
	 * If there are no more entries in the archive, null will
	 * be returned to indicate that the end of the archive has
	 * been reached.
	 *
	 * @return The next TarEntry in the archive, or null.
	 */
public TarEntry getNextEntry() throws IOException {
    if (this.hasHitEOF)
        return null;
    if (this.currEntry != null) {
        int numToSkip = this.entrySize - this.entryOffset;
        if (this.debug)
            System.err.println("TarInputStream: SKIP currENTRY '" + this.currEntry.getName() + "' SZ " + this.entrySize + " OFF " + this.entryOffset + "  skipping " + numToSkip + " bytes");
        if (numToSkip > 0) {
            this.skip(numToSkip);
        }
        this.readBuf = null;
    }
    byte[] headerBuf = this.buffer.readRecord();
    if (headerBuf == null) {
        if (this.debug) {
            System.err.println("READ NULL RECORD");
        }
        this.hasHitEOF = true;
    } else if (this.buffer.isEOFRecord(headerBuf)) {
        if (this.debug) {
            System.err.println("READ EOF RECORD");
        }
        this.hasHitEOF = true;
    }
    if (this.hasHitEOF) {
        this.currEntry = null;
    } else {
        try {
            if (this.eFactory == null) {
                this.currEntry = new TarEntry(headerBuf);
            } else {
                this.currEntry = this.eFactory.createEntry(headerBuf);
            }
            if (!(headerBuf[257] == 'u' && headerBuf[258] == 's' && headerBuf[259] == 't' && headerBuf[260] == 'a' && headerBuf[261] == 'r')) {
                throw new InvalidHeaderException("header magic is not 'ustar', but '" + headerBuf[257] + headerBuf[258] + headerBuf[259] + headerBuf[260] + headerBuf[261] + "', or (dec) " + ((int) headerBuf[257]) + ", " + ((int) headerBuf[258]) + ", " + ((int) headerBuf[259]) + ", " + ((int) headerBuf[260]) + ", " + ((int) headerBuf[261]));
            }
            if (this.debug)
                System.err.println("TarInputStream: SET CURRENTRY '" + this.currEntry.getName() + "' size = " + this.currEntry.getSize());
            this.entryOffset = 0;
            // REVIEW How do we resolve this discrepancy?!
            this.entrySize = (int) this.currEntry.getSize();
        } catch (InvalidHeaderException ex) {
            this.entrySize = 0;
            this.entryOffset = 0;
            this.currEntry = null;
            throw new InvalidHeaderException("bad header in block " + this.buffer.getCurrentBlockNum() + " record " + this.buffer.getCurrentRecordNum() + ", " + ex.getMessage());
        }
    }
    return this.currEntry;
}