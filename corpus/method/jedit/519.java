/**
	 * Return whether or not this entry represents a directory.
	 *
	 * @return True if this entry is a directory.
	 */
public boolean isDirectory() {
    if (this.file != null)
        return this.file.isDirectory();
    if (this.header != null) {
        if (this.header.linkFlag == TarHeader.LF_DIR)
            return true;
        if (this.header.name.toString().endsWith("/"))
            return true;
    }
    return false;
}