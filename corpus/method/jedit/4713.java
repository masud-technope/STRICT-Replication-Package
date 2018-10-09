/**
	 * return file modified date, this function simply return 0,
	 * VFS implementation should overwrite this to return the 
	 * real modified data 
	 */
public long getModified() {
    return 0;
}