/**
	 * Close the TarBuffer. If this is an output buffer, also flush the
	 * current block before closing.
	 */
public void close() throws IOException {
    if (this.debug) {
        System.err.println("TarBuffer.closeBuffer().");
    }
    if (this.outStream != null) {
        this.flushBlock();
        if (this.outStream != System.out && this.outStream != System.err) {
            this.outStream.close();
            this.outStream = null;
        }
    } else if (this.inStream != null) {
        if (this.inStream != System.in) {
            this.inStream.close();
            this.inStream = null;
        }
    }
}