//}}}
//{{{ updateBufferHash() method
/**
	 * @since jEdit 5.3pre1
	 */
static void updateBufferHash(Buffer buffer) {
    // path can be changed (e.g. file changed on disk into link.
    for (Iterator<Buffer> iterator = bufferHash.values().iterator(); iterator.hasNext(); ) {
        Buffer b = (Buffer) iterator.next();
        // values() collection also removes it from bufferHash
        if (buffer == b)
            iterator.remove();
    }
    String path = buffer.getSymlinkPath();
    if ((VFSManager.getVFSForPath(path).getCapabilities() & VFS.CASE_INSENSITIVE_CAP) != 0) {
        path = path.toLowerCase();
    }
    bufferHash.put(path, buffer);
}