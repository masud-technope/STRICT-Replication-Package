//}}}
//{{{ autodetect() method
/**
	 * Tries to detect if the stream is gzipped, and if it has an encoding
	 * specified with an XML PI.
	 */
protected Reader autodetect(InputStream in) throws IOException {
    return MiscUtilities.autodetect(in, buffer);
}