//}}}
//{{{ getVFS() method
/**
	 * Returns the virtual filesystem responsible for loading and
	 * saving this buffer. This method is thread-safe.
	 * @return the VFS
	 */
public VFS getVFS() {
    return VFSManager.getVFSForPath(path);
}