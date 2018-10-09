/**
	 * Writes a byte to the current tar archive entry.
	 *
	 * This method simply calls read( byte[], int, int ).
	 *
	 * @param b The byte written.
	 */
public void write(int b) throws IOException {
    this.oneBuf[0] = (byte) b;
    this.write(this.oneBuf, 0, 1);
}