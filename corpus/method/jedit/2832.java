//}}}
//{{{ getContentLength() method
/**
	 * Returns content length of this load request.
	 */
private long getContentLength() throws IOException {
    VFSFile entry = vfs._getFile(session, path, view);
    if (entry != null)
        return entry.getLength();
    else
        return 0L;
}