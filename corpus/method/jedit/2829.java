//}}}
//{{{ rewindContentsStream() method
/**
	 * Returns rewinded contents stream.
	 * This method assumes the marked stream was made by
	 * getMarkedStream() method. The stream may be reopened if reset()
	 * failed.
	 */
private BufferedInputStream rewindContentsStream(BufferedInputStream markedStream, boolean gzipped) throws IOException {
    try {
        markedStream.reset();
        return markedStream;
    } catch (IOException e) {
        Log.log(Log.NOTICE, this, path + ": Reopening to rewind the stream");
        markedStream.close();
        InputStream in = getNakedStream();
        try {
            if (gzipped) {
                in = new GZIPInputStream(in);
            }
            BufferedInputStream result = AutoDetection.getMarkedStream(in);
            in = null;
            return result;
        } finally {
            IOUtilities.closeQuietly((Closeable) in);
        }
    }
}