//}}}
//{{{ hasChangedOnDisk() method
/**
	 * Returns true if the file has been changed on disk.
	 * This is based on the last modified time at the last saving
	 * or loading.
	 */
public boolean hasChangedOnDisk() {
    return file.exists() && (file.lastModified() != knownLastModified);
}