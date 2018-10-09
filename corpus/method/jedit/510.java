/**
	 * Construct an entry from an archive's header bytes. File is set
	 * to null.
	 *
	 * @param headerBuf The header bytes from a tar archive entry.
	 */
public  TarEntry(byte[] headerBuf) throws InvalidHeaderException {
    this.initialize();
    this.parseTarHeader(this.header, headerBuf);
}