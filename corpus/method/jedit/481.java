/**
	 * Flush the current data block if it has any data in it.
	 */
private void flushBlock() throws IOException {
    if (this.debug) {
        System.err.println("TarBuffer.flushBlock() called.");
    }
    if (this.outStream == null)
        throw new IOException("writing to an input buffer");
    if (this.currRecIdx > 0) {
        this.writeBlock();
    }
}