/**
	 * Writes bytes to the current tar archive entry.
	 *
	 * This method simply calls read( byte[], int, int ).
	 *
	 * @param wBuf The buffer to write to the archive.
	 * @return The number of bytes read, or -1 at EOF.
	 */
public void write(byte[] wBuf) throws IOException {
    this.write(wBuf, 0, wBuf.length);
}