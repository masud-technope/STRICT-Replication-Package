/**
     * Parse an entry's header information from a header buffer.
     *
     * @param header The ar entry header buffer to get information from.
     */
public void parseArHeader(byte[] header) {
    throw new UnsupportedOperationException("parseArHeader(byte[]) not yet implmented");
//        int offset = 0;
//
//        this.filename = TarUtils.parseName(header, offset, NAMELEN);
//        offset += NAMELEN;
//        this.fileDate = TarUtils.parseOctal(header, offset, FILEDATELEN);
//        offset += FILEDATELEN;
//        this.userId = (int) TarUtils.parseOctal(header, offset, UIDLEN);
//        offset += UIDLEN;
//        this.groupId = (int) TarUtils.parseOctal(header, offset, GIDLEN);
//        offset += GIDLEN;
//        this.mode = (int) TarUtils.parseOctal(header, offset, MODELEN);
//        offset += MODELEN;
//        this.size = TarUtils.parseOctal(header, offset, SIZELEN);
//        offset += SIZELEN;
//        this.magic = TarUtils.parseName(header, offset, MAGICLEN);
//        offset += MAGICLEN;
}