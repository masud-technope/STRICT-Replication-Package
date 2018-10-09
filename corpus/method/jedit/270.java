/**
     * Construct an entry from an archive's header bytes. File is set
     * to null.
     *
     * @param headerBuf The header bytes from an ar archive entry.
     */
public  ArEntry(byte[] headerBuf) {
    this();
    this.parseArHeader(headerBuf);
}