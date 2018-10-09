/**
	 * Get the available data that can be read from the current
	 * entry in the archive. This does not indicate how much data
	 * is left in the entire archive, only in the current entry.
	 * This value is determined from the entry's size header field
	 * and the amount of data already read from the current entry.
	 * 
	 *
	 * @return The number of available bytes for the current entry.
	 */
public int available() throws IOException {
    return this.entrySize - this.entryOffset;
}