//}}}
//{{{ getFilePath() method
/**
	 * Returns the path component of the specified VFS path.
	 * The standard implementation cuts off the protocol
	 * and the protocol separator character and then delegates
	 * to eventually present sub-VFS-paths present in the VFS path
	 * like "jode:archive:/test.zip!/test.txt".
	 * <p>
	 * If a VFS implementation can have additional
	 * information in the VFS path like username / password / host / port
	 * for FTP VFS or archive filename for archive VFS, this
	 * method should be overridden to remove those information also.
	 * The easiest would be to remove those additional information
	 * and then delegate to {@code super.getFilePath()}.
	 *
	 * @param vfsPath The VFS path
	 * @since jEdit 4.5pre1
	 */
public String getFilePath(String vfsPath) {
    if (!MiscUtilities.isURL(vfsPath))
        return vfsPath;
    String filePath = vfsPath.substring(MiscUtilities.getProtocolOfURL(vfsPath).length() + 1);
    return VFSManager.getVFSForPath(filePath).getFilePath(filePath);
}