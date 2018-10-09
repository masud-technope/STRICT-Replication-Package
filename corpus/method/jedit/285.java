/**
     * Writes a byte to the current ar archive entry.
     *
     * This method simply calls write( byte[], int, int ).
     *
     * @param b The byte to write to the archive.
     */
public void write(int b) throws IOException {
    this.oneBuf[0] = (byte) b;
    this.write(this.oneBuf, 0, 1);
}