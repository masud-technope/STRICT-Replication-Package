/**
	 * Skip bytes in the input buffer. This skips bytes in the
	 * current entry's data, not the entire archive, and will
	 * stop at the end of the current entry's data if the number
	 * to skip extends beyond that point.
	 *
	 * @param numToSkip The number of bytes to skip.
	 */
public void skip(int numToSkip) throws IOException {
    // REVIEW
    // This is horribly inefficient, but it ensures that we
    // properly skip over bytes via the TarBuffer...
    //
    byte[] skipBuf = new byte[8 * 1024];
    for (int num = numToSkip; num > 0; ) {
        int numRead = this.read(skipBuf, 0, (num > skipBuf.length ? skipBuf.length : num));
        if (numRead == -1)
            break;
        num -= numRead;
    }
}