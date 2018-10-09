/**
	 * Copy a file to another using VFS.
	 *
	 * @param progress the progress observer. It could be null if you don't want to monitor progress. If not null
	 *                  you should probably launch this command in a WorkThread
	 * @param sourcePath the source path
	 * @param targetPath the target path
	 * @param comp The component that will parent error dialog boxes
	 * @param canStop if true the copy can be stopped
	 * @return true if the copy was successful
	 * @throws IOException IOException If an I/O error occurs
	 * @since jEdit 4.3pre3
	 */
public static boolean copy(ProgressObserver progress, String sourcePath, String targetPath, Component comp, boolean canStop) throws IOException {
    return copy(progress, sourcePath, targetPath, comp, canStop, true);
}