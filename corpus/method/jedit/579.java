/**
	 * Writes bytes to the current tar archive entry. This method
	 * is aware of the current entry and will throw an exception if
	 * you attempt to write bytes past the length specified for the
	 * current entry. The method is also (painfully) aware of the
	 * record buffering required by TarBuffer, and manages buffers
	 * that are not a multiple of recordsize in length, including
	 * assembling records from small buffers.
	 *
	 * This method simply calls read( byte[], int, int ).
	 *
	 * @param wBuf The buffer to write to the archive.
	 * @param wOffset The offset in the buffer from which to get bytes.
	 * @param numToWrite The number of bytes to write.
	 */
public void write(byte[] wBuf, int wOffset, int numToWrite) throws IOException {
    if ((this.currBytes + numToWrite) > this.currSize)
        throw new IOException("request to write '" + numToWrite + "' bytes exceeds size in header of '" + this.currSize + "' bytes");
    //
    if (this.assemLen > 0) {
        if ((this.assemLen + numToWrite) >= this.recordBuf.length) {
            int aLen = this.recordBuf.length - this.assemLen;
            System.arraycopy(this.assemBuf, 0, this.recordBuf, 0, this.assemLen);
            System.arraycopy(wBuf, wOffset, this.recordBuf, this.assemLen, aLen);
            this.buffer.writeRecord(this.recordBuf);
            this.currBytes += this.recordBuf.length;
            wOffset += aLen;
            numToWrite -= aLen;
            this.assemLen = 0;
        } else // ( (this.assemLen + numToWrite ) < this.recordBuf.length )
        {
            System.arraycopy(wBuf, wOffset, this.assemBuf, this.assemLen, numToWrite);
            wOffset += numToWrite;
            this.assemLen += numToWrite;
            numToWrite -= numToWrite;
        }
    }
    for (; numToWrite > 0; ) {
        if (numToWrite < this.recordBuf.length) {
            System.arraycopy(wBuf, wOffset, this.assemBuf, this.assemLen, numToWrite);
            this.assemLen += numToWrite;
            break;
        }
        this.buffer.writeRecord(wBuf, wOffset);
        int num = this.recordBuf.length;
        this.currBytes += num;
        numToWrite -= num;
        wOffset += num;
    }
}