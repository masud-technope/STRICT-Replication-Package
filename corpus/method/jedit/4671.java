//}}}
//{{{ copy() methods
/**
	 * Copy a file to another using VFS.
	 *
	 * @param progress the progress observer. It could be null if you don't want to monitor progress. If not null
	 *                  you should probably launch this command in a WorkThread
	 * @param sourceVFS the source VFS
	 * @param sourceSession the VFS session
	 * @param sourcePath the source path. It must be a file and must exists
	 * @param targetVFS the target VFS
	 * @param targetSession the target session
	 * @param targetPath the target path.
	 * If it is a path, it must exists, if it is a file, the parent must
	 * exists
	 * @param comp The component that will parent error dialog boxes
	 * @param canStop could this copy be stopped ?
	 * @return true if the copy was successful
	 * @throws IOException  IOException If an I/O error occurs
	 * @since jEdit 4.3pre3
	 */
public static boolean copy(ProgressObserver progress, VFS sourceVFS, Object sourceSession, String sourcePath, VFS targetVFS, Object targetSession, String targetPath, Component comp, boolean canStop) throws IOException {
    return copy(progress, sourceVFS, sourceSession, sourcePath, targetVFS, targetSession, targetPath, comp, canStop, true);
}