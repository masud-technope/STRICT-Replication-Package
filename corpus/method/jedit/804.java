/**
	 * Rename a file.
	 * It will prompt for the new name.
	 * @param from the file to rename
	 * @param to the target name
	 * @since jEdit 4.5pre1
	 */
public void rename(VFSFile from, String to) {
    rename(from.getVFS(), from.getPath(), to);
}