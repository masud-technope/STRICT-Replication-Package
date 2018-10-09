public String makeBufferPropertyName(Buffer theBuffer, String prefix) {
    StringBuilder propName = new StringBuilder(prefix);
    // Convert any Windows-style file separators to Unix ones, since
    // backslashes are special characters in properties files.
    String fileSep = System.getProperty("file.separator");
    String bufName;
    if (!fileSep.equals("/")) {
        // backslash here.
        if (fileSep.equals("\\"))
            fileSep = new StringBuilder(fileSep).append('\\').toString();
        bufName = theBuffer.getPath().replaceAll(fileSep, "/");
    } else {
        bufName = theBuffer.getPath();
    }
    propName.append(bufName);
    return propName.toString();
}