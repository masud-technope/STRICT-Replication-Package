/**
	 * Close an entry. This method MUST be called for all file
	 * entries that contain data. The reason is that we must
	 * buffer data written to the stream in order to satisfy
	 * the buffer's record based writes. Thus, there may be
	 * data fragments still being assembled that must be written
	 * to the output stream before this entry is closed and the
	 * next entry written.
	 */
public void closeEntry() throws IOException {
    if (this.assemLen > 0) {
        for (int i = this.assemLen; i < this.assemBuf.length; ++i) this.assemBuf[i] = 0;
        this.buffer.writeRecord(this.assemBuf);
        this.currBytes += this.assemLen;
        this.assemLen = 0;
    }
    if (this.currBytes < this.currSize)
        throw new IOException("entry closed at '" + this.currBytes + "' before the '" + this.currSize + "' bytes specified in the header were written");
}