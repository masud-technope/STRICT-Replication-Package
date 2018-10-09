/**
	 * Ends the TAR archive and closes the underlying OutputStream.
	 * This means that finish() is called followed by calling the
	 * TarBuffer's close().
	 */
public void close() throws IOException {
    this.finish();
    this.buffer.close();
}