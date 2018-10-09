//{{{ readXml() method
/**
	 * Read and store the mirror list xml.
	 * @throws IOException exception if it was not possible to read the
	 * xml or if the url was invalid
	 */
private void readXml() throws IOException {
    String settingsDirectory = jEdit.getSettingsDirectory();
    if (settingsDirectory == null)
        return;
    File mirrorList = new File(MiscUtilities.constructPath(settingsDirectory, "mirrorList.xml"));
    if (!mirrorList.exists())
        return;
    InputStream inputStream = null;
    try {
        inputStream = new BufferedInputStream(new FileInputStream(mirrorList));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        IOUtilities.copyStream(null, inputStream, out, false);
        xml = out.toString();
    } finally {
        IOUtilities.closeQuietly((Closeable) inputStream);
    }
}