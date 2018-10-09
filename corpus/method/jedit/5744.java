//}}}
//{{{ downloadXml() method
/**
	 * Read and store the mirror list xml.
	 *
	 * @param path the url
	 * @throws IOException exception if it was not possible to read the
	 * xml or if the url was invalid
	 */
private void downloadXml(String path) throws IOException {
    InputStream inputStream = null;
    try {
        inputStream = new URL(path).openStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        IOUtilities.copyStream(null, inputStream, out, false);
        xml = out.toString();
    } finally {
        IOUtilities.closeQuietly((Closeable) inputStream);
    }
}