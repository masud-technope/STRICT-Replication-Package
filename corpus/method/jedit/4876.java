//}}}
//}}} Miscellaneous methods fold end
//{{{ Package-private members
//{{{ updatePosition() method
/**
	 * If buffer sorting is enabled, this repositions the buffer.
	 */
static void updatePosition(String oldPath, Buffer buffer) {
    if ((VFSManager.getVFSForPath(oldPath).getCapabilities() & VFS.CASE_INSENSITIVE_CAP) != 0) {
        oldPath = oldPath.toLowerCase();
    }
    bufferHash.remove(oldPath);
    String path = buffer.getSymlinkPath();
    if ((VFSManager.getVFSForPath(path).getCapabilities() & VFS.CASE_INSENSITIVE_CAP) != 0) {
        path = path.toLowerCase();
    }
    bufferHash.put(path, buffer);
    if (sortBuffers) {
        removeBufferFromList(buffer);
        addBufferToList(buffer);
    }
}