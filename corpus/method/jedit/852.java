/**
	 * Rename a file
	 * @param from the full path name of the file to be renamed
	 * @param newname the new name (only filename, not full path)
	 */
public void rename(String from, String newname) {
    VFS vfs = VFSManager.getVFSForPath(from);
    rename(vfs, from, newname);
}