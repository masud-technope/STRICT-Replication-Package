//}}}
//{{{ getZipFile() method
/**
	 * Returns the plugin's JAR file, opening it if necessary.
	 * @since jEdit 4.2pre1
	 */
public synchronized ZipFile getZipFile() throws IOException {
    if (zipFile == null) {
        Log.log(Log.DEBUG, this, "Opening " + path);
        zipFile = new ZipFile(path);
    }
    return zipFile;
}