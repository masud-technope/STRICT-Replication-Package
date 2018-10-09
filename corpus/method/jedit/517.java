/**
	 * If this entry represents a file, and the file is a directory, return
	 * an array of TarEntries for this entry's children.
	 *
	 * @return An array of TarEntry's for this entry's children.
	 */
public TarEntry[] getDirectoryEntries() throws InvalidHeaderException {
    if (this.file == null || !this.file.isDirectory()) {
        return new TarEntry[0];
    }
    String[] list = this.file.list();
    TarEntry[] result = new TarEntry[list.length];
    for (int i = 0; i < list.length; ++i) {
        result[i] = new TarEntry(new File(this.file, list[i]));
    }
    return result;
}