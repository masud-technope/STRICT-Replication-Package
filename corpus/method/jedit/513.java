/**
	 * Construct an entry for a file. File is set to file, and the
	 * header is constructed from information from the file.
	 *
	 * @param file The file that the entry represents.
	 */
public  TarEntry(File file) throws InvalidHeaderException {
    this.initialize();
    this.getFileTarHeader(this.header, file);
}