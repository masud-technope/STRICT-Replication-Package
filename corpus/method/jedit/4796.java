//}}}
//{{{ getBuffer() method
/**
	 * Returns the buffer with the specified path name. The path name
	 * must be an absolute path. This method automatically resolves
	 * symbolic links. If performance is critical, cache the canonical
	 * path and call {@link #_getBuffer(String)} instead.
	 *
	 * @param path The path name
	 *
	 * @return the searched buffer, or null if it is not already open
	 *
	 * @see MiscUtilities#constructPath(String,String)
	 * @see MiscUtilities#resolveSymlinks(String)
	 */
public static Buffer getBuffer(String path) {
    return _getBuffer(MiscUtilities.resolveSymlinks(path));
}