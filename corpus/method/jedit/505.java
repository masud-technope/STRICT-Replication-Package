/**
	 * Parse an entry's TarHeader information from a header buffer.
	 *
	 * @param hdr The TarHeader to fill in from the buffer information.
	 * @param header The tar entry header buffer to get information from.
	 */
public void parseTarHeader(TarHeader hdr, byte[] header) throws InvalidHeaderException {
    int offset = 0;
    hdr.name = TarHeader.parseName(header, offset, TarHeader.NAMELEN);
    offset += TarHeader.NAMELEN;
    hdr.mode = (int) TarHeader.parseOctal(header, offset, TarHeader.MODELEN);
    offset += TarHeader.MODELEN;
    hdr.userId = (int) TarHeader.parseOctal(header, offset, TarHeader.UIDLEN);
    offset += TarHeader.UIDLEN;
    hdr.groupId = (int) TarHeader.parseOctal(header, offset, TarHeader.GIDLEN);
    offset += TarHeader.GIDLEN;
    hdr.size = TarHeader.parseOctal(header, offset, TarHeader.SIZELEN);
    offset += TarHeader.SIZELEN;
    hdr.modTime = TarHeader.parseOctal(header, offset, TarHeader.MODTIMELEN);
    offset += TarHeader.MODTIMELEN;
    hdr.checkSum = (int) TarHeader.parseOctal(header, offset, TarHeader.CHKSUMLEN);
    offset += TarHeader.CHKSUMLEN;
    hdr.linkFlag = header[offset++];
    hdr.linkName = TarHeader.parseName(header, offset, TarHeader.NAMELEN);
    offset += TarHeader.NAMELEN;
    hdr.magic = TarHeader.parseName(header, offset, TarHeader.MAGICLEN);
    offset += TarHeader.MAGICLEN;
    hdr.userName = TarHeader.parseName(header, offset, TarHeader.UNAMELEN);
    offset += TarHeader.UNAMELEN;
    hdr.groupName = TarHeader.parseName(header, offset, TarHeader.GNAMELEN);
    offset += TarHeader.GNAMELEN;
    hdr.devMajor = (int) TarHeader.parseOctal(header, offset, TarHeader.DEVLEN);
    offset += TarHeader.DEVLEN;
    hdr.devMinor = (int) TarHeader.parseOctal(header, offset, TarHeader.DEVLEN);
}