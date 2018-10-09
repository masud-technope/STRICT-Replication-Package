/**
	 * Put an entry on the output stream. This writes the entry's
	 * header record and positions the output stream for writing
	 * the contents of the entry. Once this method is called, the
	 * stream is ready for calls to write() to write the entry's
	 * contents. Once the contents are written, closeEntry()
	 * <B>MUST</B> be called to ensure that all buffered data
	 * is completely written to the output stream.
	 *
	 * @param entry The TarEntry to be written to the archive.
	 */
public void putNextEntry(TarEntry entry) throws IOException {
    if (entry.getHeader().name.length() > TarHeader.NAMELEN)
        throw new InvalidHeaderException("file name '" + entry.getHeader().name + "' is too long ( > " + TarHeader.NAMELEN + " bytes )");
    entry.writeEntryHeader(this.recordBuf);
    this.buffer.writeRecord(this.recordBuf);
    this.currBytes = 0;
    if (entry.isDirectory())
        this.currSize = 0;
    else
        this.currSize = (int) entry.getSize();
}