//}}}
//{{{ isBinary() method
/**
	 * Check if a file is binary file.
	 *
	 * @param session the VFS session
	 * @return <code>true</code> if the file was detected as binary
	 * @throws IOException IOException If an I/O error occurs
	 * @since jEdit 4.3pre5
	 */
public boolean isBinary(Object session) throws IOException {
    InputStream in = getVFS()._createInputStream(session, getPath(), false, jEdit.getActiveView());
    if (in == null)
        throw new IOException("Unable to get a Stream for this file " + this);
    try {
        return MiscUtilities.isBinary(in);
    } finally {
        IOUtilities.closeQuietly((Closeable) in);
    }
}