/**
     * Writes bytes to the current ar archive entry. This method
     * is aware of the current entry and will throw an exception if
     * you attempt to write bytes past the length specified for the
     * current entry.
     *
     * @param wBuf The buffer to write to the archive.
     * @param wOffset The offset in the buffer from which to get bytes.
     * @param numToWrite The number of bytes to write.
     */
public void write(byte[] wBuf, int wOffset, int numToWrite) throws IOException {
    if (!inEntry) {
        throw new IOException("we are not in an entry currently");
    }
    if ((this.currBytes + numToWrite) > this.currSize) {
        throw new IOException("request to write '" + numToWrite + "' bytes exceeds size in header of '" + this.currSize + "' bytes");
    }
    if (numToWrite > 0) {
        this.out.write(wBuf, wOffset, numToWrite);
        this.currBytes += numToWrite;
    }
}