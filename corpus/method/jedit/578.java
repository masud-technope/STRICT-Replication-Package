/**
	 * Write an EOF (end of archive) record to the tar archive.
	 * An EOF record consists of a record of all zeros.
	 */
private void writeEOFRecord() throws IOException {
    for (int i = 0; i < this.recordBuf.length; ++i) this.recordBuf[i] = 0;
    this.buffer.writeRecord(this.recordBuf);
}