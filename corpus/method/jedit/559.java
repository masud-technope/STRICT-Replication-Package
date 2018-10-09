/**
	 * Copies the contents of the current tar archive entry directly into
	 * an output stream.
	 *
	 * @param out The OutputStream into which to write the entry's data.
	 */
public void copyEntryContents(OutputStream out) throws IOException {
    byte[] buf = new byte[32 * 1024];
    for (; ; ) {
        int numRead = this.read(buf, 0, buf.length);
        if (numRead == -1)
            break;
        out.write(buf, 0, numRead);
    }
}