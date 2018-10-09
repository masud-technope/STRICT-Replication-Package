/**
	 * Convenience method that will modify an entry's name directly
	 * in place in an entry header buffer byte array.
	 *
	 * @param outbuf The buffer containing the entry header to modify.
	 * @param newName The new name to place into the header buffer.
	 */
public void adjustEntryName(byte[] outbuf, String newName) {
    int offset = 0;
    offset = TarHeader.getNameBytes(new StringBuffer(newName), outbuf, offset, TarHeader.NAMELEN);
}