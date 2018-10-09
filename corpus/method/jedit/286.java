/**
     * Writes bytes to the current ar archive entry.
     *
     * This method simply calls write( byte[], int, int ).
     *
     * @param wBuf The buffer to write to the archive.
     */
public void write(byte[] wBuf) throws IOException {
    this.write(wBuf, 0, wBuf.length);
}