/**
	 * Reads a byte from the current tar archive entry.
	 *
	 * This method simply calls read( byte[], int, int ).
	 *
	 * @return The byte read, or -1 at EOF.
	 */
public int read() throws IOException {
    int num = this.read(this.oneBuf, 0, 1);
    if (num == -1)
        return num;
    else
        return this.oneBuf[0];
}