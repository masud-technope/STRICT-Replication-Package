/**
	 * Write an entry's header information to a header buffer.
	 *
	 * @param outbuf The tar entry header buffer to fill in.
	 */
public void writeEntryHeader(byte[] outbuf) {
    int offset = 0;
    offset = TarHeader.getNameBytes(this.header.name, outbuf, offset, TarHeader.NAMELEN);
    offset = TarHeader.getOctalBytes(this.header.mode, outbuf, offset, TarHeader.MODELEN);
    offset = TarHeader.getOctalBytes(this.header.userId, outbuf, offset, TarHeader.UIDLEN);
    offset = TarHeader.getOctalBytes(this.header.groupId, outbuf, offset, TarHeader.GIDLEN);
    long size = this.header.size;
    offset = TarHeader.getLongOctalBytes(size, outbuf, offset, TarHeader.SIZELEN);
    offset = TarHeader.getLongOctalBytes(this.header.modTime, outbuf, offset, TarHeader.MODTIMELEN);
    int csOffset = offset;
    for (int c = 0; c < TarHeader.CHKSUMLEN; ++c) outbuf[offset++] = (byte) ' ';
    outbuf[offset++] = this.header.linkFlag;
    offset = TarHeader.getNameBytes(this.header.linkName, outbuf, offset, TarHeader.NAMELEN);
    offset = TarHeader.getNameBytes(this.header.magic, outbuf, offset, TarHeader.MAGICLEN);
    offset = TarHeader.getNameBytes(this.header.userName, outbuf, offset, TarHeader.UNAMELEN);
    offset = TarHeader.getNameBytes(this.header.groupName, outbuf, offset, TarHeader.GNAMELEN);
    offset = TarHeader.getOctalBytes(this.header.devMajor, outbuf, offset, TarHeader.DEVLEN);
    offset = TarHeader.getOctalBytes(this.header.devMinor, outbuf, offset, TarHeader.DEVLEN);
    for (; offset < outbuf.length; ) outbuf[offset++] = 0;
    long checkSum = this.computeCheckSum(outbuf);
    TarHeader.getCheckSumOctalBytes(checkSum, outbuf, csOffset, TarHeader.CHKSUMLEN);
}