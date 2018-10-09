//}}}
//{{{ openFile() methods
/**
	 * Opens a file, either immediately if the application is finished starting up,
	 * or after the first view has been created if not.
	 * @param path The file path
	 *
	 * @return the buffer if succesfully loaded immediately, or null otherwise
	 *
	 * @since jEdit 4.5pre1
	 */
public static Buffer openFileAfterStartup(String path) {
    if (isStartupDone()) {
        return openFile(getActiveView(), path);
    } else {
        // These additional file names will be treated just as if they had
        // been passed on the command line
        additionalFiles.add(path);
        return null;
    }
}