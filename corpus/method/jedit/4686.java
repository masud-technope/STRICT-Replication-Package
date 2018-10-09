//}}}
//{{{ getVFS() method
/**
	 * @return The originating virtual file system of this file.
	 */
public VFS getVFS() {
    return VFSManager.getVFSForPath(path);
}