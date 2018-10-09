//{{{ getMarkedStream() method
/**
	 * Returns a marked, rewindable stream.
	 * Calling reset() method rewinds the stream to its beginning.
	 * But reset() can fail if too long bytes were read.
	 */
public static BufferedInputStream getMarkedStream(InputStream in) {
    int bufferSize = BufferIORequest.getByteIOBufferSize();
    BufferedInputStream markable = new BufferedInputStream(in, bufferSize);
    assert (markable.markSupported());
    markable.mark(bufferSize);
    return markable;
}