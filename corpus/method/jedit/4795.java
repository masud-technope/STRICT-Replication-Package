//}}}
//{{{ _getBuffer() method
/**
	 * Returns the buffer with the specified path name. The path name
	 * must be an absolute, canonical, path.
	 *
	 * @param path The path name
	 *
	 * @return the searched buffer, or null if it is not already open
	 *
	 * @see MiscUtilities#constructPath(String,String)
	 * @see MiscUtilities#resolveSymlinks(String)
	 * @see #getBuffer(String)
	 *
	 * @since jEdit 4.2pre7
	 */
public static Buffer _getBuffer(String path) {
    // case in the hash.
    if ((VFSManager.getVFSForPath(path).getCapabilities() & VFS.CASE_INSENSITIVE_CAP) != 0) {
        path = path.toLowerCase();
    }
    // TODO: danson, this causes ProjectViewer to block, not sure why yet
    synchronized (bufferListLock) {
        return bufferHash.get(path);
    }
}