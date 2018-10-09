/**
     * Put an entry on the output stream. This writes the entry's
     * header record and positions the output stream for writing
     * the contents of the entry. Once this method is called, the
     * stream is ready for calls to write() to write the entry's
     * contents. Once the contents are written, closeEntry()
     * <B>MUST</B> be called to ensure that all buffered data
     * is completely written to the output stream.
     *
     * @param entry The ArEntry to be written to the archive.
     */
public void putNextEntry(ArEntry entry) throws IOException {
    writingStarted = true;
    if (inEntry) {
        throw new IOException("the current entry has to be closed before starting a new one");
    }
    String filename = entry.getFilename();
    if ((filename.length() >= ArConstants.NAMELEN) && (longFileMode != LONGFILE_TRUNCATE)) {
        throw new RuntimeException("file name \"" + entry.getFilename() + "\" is too long ( > " + ArConstants.NAMELEN + " bytes )");
    }
    if (-1 != filename.indexOf(' ')) {
        if (longFileMode == LONGFILE_TRUNCATE) {
            entry.setFilename(filename.replace(' ', '_'));
        } else {
            throw new RuntimeException("file name \"" + entry.getFilename() + "\" contains spaces");
        }
    }
    byte[] headerBuf = new byte[ArConstants.HEADERLENGTH];
    entry.writeEntryHeader(headerBuf);
    this.out.write(headerBuf, 0, ArConstants.HEADERLENGTH);
    this.currBytes = 0;
    this.currSize = (int) entry.getSize();
    inEntry = true;
}