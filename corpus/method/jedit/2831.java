//}}}
//{{{ getNakedStream() method
/**
	 * Returns the raw contents stream for this load request.
	 * This stream is not buffered or unzipped.
	 */
private InputStream getNakedStream() throws IOException {
    InputStream in = vfs._createInputStream(session, path, false, view);
    if (in != null) {
        return in;
    }
    throw new IOException("Unable to get a Stream for " + path);
}