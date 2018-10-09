/**
	 * Reads bytes from the current tar archive entry.
	 *
	 * This method simply calls read( byte[], int, int ).
	 *
	 * @param buf The buffer into which to place bytes read.
	 * @return The number of bytes read, or -1 at EOF.
	 */
public int read(byte[] buf) throws IOException {
    return this.read(buf, 0, buf.length);
}