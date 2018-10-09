/**
     * Construct an entry for a file. File is set to file, and the
     * header is constructed from information from the file.
     *
     * @param file The file that the entry represents.
     */
public  ArEntry(File file) {
    this();
    if (file.isDirectory()) {
        throw new IllegalArgumentException("ar archives can only contain files");
    }
    this.file = file;
    this.filename = new StringBuffer(file.getName());
    this.fileDate = file.lastModified() / MILLIS_PER_SECOND;
    this.mode = DEFAULT_FILE_MODE;
    this.size = file.length();
}