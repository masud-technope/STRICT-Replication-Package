/**
	 * Fill in a TarHeader given only the entry's name.
	 *
	 * @param hdr The TarHeader to fill in.
	 * @param name The tar entry name.
	 */
public void nameTarHeader(TarHeader hdr, String name) {
    boolean isDir = name.endsWith("/");
    hdr.checkSum = 0;
    hdr.devMajor = 0;
    hdr.devMinor = 0;
    hdr.name = new StringBuffer(name);
    hdr.mode = isDir ? 040755 : 0100644;
    hdr.userId = 0;
    hdr.groupId = 0;
    hdr.size = 0;
    hdr.checkSum = 0;
    hdr.modTime = (new java.util.Date()).getTime() / 1000;
    hdr.linkFlag = isDir ? TarHeader.LF_DIR : TarHeader.LF_NORMAL;
    hdr.linkName = new StringBuffer("");
    hdr.userName = new StringBuffer("");
    hdr.groupName = new StringBuffer("");
    hdr.devMajor = 0;
    hdr.devMinor = 0;
}