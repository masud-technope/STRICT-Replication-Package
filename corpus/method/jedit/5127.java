// }}}
//{{{ prepareAutosaveDirectory method
/**
	 * Prepares the directory to autosave the specified file.
	 * A jEdit property is used to determine the directory.
	 * If there is none specified by props,
	 * then the current directory is used, but only for local files.
	 * The directory is created if it does not exist.
	 * @param path path to the buffer
	 * @return Autosave directory. <code>null</code> is returned for
	 * non-local files if no backup directory is specified in properties.
	 * @since jEdit 5.5
	 */
public static File prepareAutosaveDirectory(String path) {
    boolean isLocal = VFSManager.getVFSForPath(path) instanceof FileVFS;
    File file;
    if (isLocal)
        file = new File(path);
    else
        file = new File(replaceNonPathChars(path, "_"));
    File dir = file;
    if (!dir.isDirectory())
        dir = dir.getParentFile();
    // Check for autosave.directory
    String autosaveDirectory = jEdit.getProperty("autosave.directory");
    if (autosaveDirectory != null) {
        autosaveDirectory = MiscUtilities.expandVariables(autosaveDirectory);
        if (path.startsWith(autosaveDirectory))
            return dir;
        // Perhaps here we would want to guard with
        // a property for parallel backups or not.
        autosaveDirectory = MiscUtilities.concatPath(autosaveDirectory, dir.getAbsolutePath());
        dir = new File(autosaveDirectory);
        if (!dir.exists())
            dir.mkdirs();
    } else {
        if (!isLocal)
            return null;
    }
    return dir;
}