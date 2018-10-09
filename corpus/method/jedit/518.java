/**
	 * Fill in a TarHeader with information from a File.
	 *
	 * @param hdr The TarHeader to fill in.
	 * @param file The file from which to get the header information.
	 */
public void getFileTarHeader(TarHeader hdr, File file) throws InvalidHeaderException {
    this.file = file;
    String name = file.getPath();
    String osname = System.getProperty("os.name");
    if (osname != null) {
        // Strip off drive letters!
        // REVIEW Would a better check be "(File.separator == '\')"?
        // String Win32Prefix = "Windows";
        // String prefix = osname.substring( 0, Win32Prefix.length() );
        // if ( prefix.equalsIgnoreCase( Win32Prefix ) )
        // if ( File.separatorChar == '\\' )
        // Per Patrick Beard:
        String Win32Prefix = "windows";
        if (osname.toLowerCase().startsWith(Win32Prefix)) {
            if (name.length() > 2) {
                char ch1 = name.charAt(0);
                char ch2 = name.charAt(1);
                if (ch2 == ':' && ((ch1 >= 'a' && ch1 <= 'z') || (ch1 >= 'A' && ch1 <= 'Z'))) {
                    name = name.substring(2);
                }
            }
        }
    }
    name = name.replace(File.separatorChar, '/');
    for (; name.startsWith("/"); ) name = name.substring(1);
    hdr.linkName = new StringBuffer("");
    hdr.name = new StringBuffer(name);
    if (file.isDirectory()) {
        hdr.mode = 040755;
        hdr.linkFlag = TarHeader.LF_DIR;
        if (hdr.name.charAt(hdr.name.length() - 1) != '/')
            hdr.name.append("/");
    } else {
        hdr.mode = 0100644;
        hdr.linkFlag = TarHeader.LF_NORMAL;
    }
    // UNDONE When File lets us get the userName, use it!
    hdr.size = file.length();
    hdr.modTime = file.lastModified() / 1000;
    hdr.checkSum = 0;
    hdr.devMajor = 0;
    hdr.devMinor = 0;
}