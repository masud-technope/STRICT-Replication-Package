/**
     * Write an entry's header information to a header buffer.
     *
     * @param outbuf The tar entry header buffer to fill in.
     */
public void writeEntryHeader(byte[] outbuf) {
    int offset = 0;
    offset = ArUtils.getNameBytes(this.filename, outbuf, offset, NAMELEN);
    offset = ArUtils.getLongBytes(this.fileDate, outbuf, offset, FILEDATELEN);
    offset = ArUtils.getIntegerBytes(this.userId, outbuf, offset, UIDLEN);
    offset = ArUtils.getIntegerBytes(this.groupId, outbuf, offset, GIDLEN);
    offset = ArUtils.getOctalBytes(this.mode, outbuf, offset, MODELEN);
    offset = ArUtils.getLongBytes(this.size, outbuf, offset, SIZELEN);
    offset = ArUtils.getNameBytes(this.magic, outbuf, offset, MAGICLEN);
    while (offset < outbuf.length) {
        outbuf[offset++] = 0;
    }
}