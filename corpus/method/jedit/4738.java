//}}}
//{{{ getVFSForPath() method
/**
	 * Returns the VFS for the specified path.
	 * @param path The path
	 * @since jEdit 2.6pre4
	 */
public static VFS getVFSForPath(String path) {
    if (MiscUtilities.isURL(path))
        return getVFSForProtocol(MiscUtilities.getProtocolOfURL(path));
    else
        return fileVFS;
}