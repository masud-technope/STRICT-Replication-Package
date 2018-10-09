/**
	 * Ends the TAR archive without closing the underlying OutputStream.
	 * The result is that the EOF record of nulls is written.
	 */
public void finish() throws IOException {
    this.writeEOFRecord();
}