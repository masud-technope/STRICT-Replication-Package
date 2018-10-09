//}}}
//{{{ getVFSForProtocol() method
/**
	 * Returns the VFS for the specified protocol.
	 * @param protocol The protocol
	 * @since jEdit 2.5pre1
	 */
public static VFS getVFSForProtocol(String protocol) {
    if (protocol.equals("file"))
        return fileVFS;
    else {
        VFS vfs = (VFS) ServiceManager.getService(SERVICE, protocol);
        if (vfs != null)
            return vfs;
        else
            return urlVFS;
    }
}