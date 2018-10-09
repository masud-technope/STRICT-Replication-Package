/**
	 * Closes this stream. Calls the TarBuffer's close() method.
	 */
public void close() throws IOException {
    this.buffer.close();
}