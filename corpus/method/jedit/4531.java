//}}}
//{{{ isGzipped() method
/**
	 * Returns wheather the stream is gzipped.
	 * This method reads a few bytes from the sample. So a caller
	 * must take care of mark() to reuse the contents. Wraping the
	 * stream by getMarkedStream() is suitable.
	 */
public static boolean isGzipped(InputStream sample) throws IOException {
    int magic1 = GZIPInputStream.GZIP_MAGIC & 0xff;
    int magic2 = (GZIPInputStream.GZIP_MAGIC >> 8) & 0xff;
    return sample.read() == magic1 && sample.read() == magic2;
}