//{{{ moveFile() method
/**
	 * Moves the source file to the destination.
	 *
	 * If the destination cannot be created or is a read-only file, the
	 * method returns <code>false</code>. Otherwise, the contents of the
	 * source are copied to the destination, the source is deleted,
	 * and <code>true</code> is returned.
	 *
	 * @param source The source file to move.
	 * @param dest   The destination where to move the file.
	 * @return true on success, false otherwise.
	 *
	 * @since jEdit 4.3pre9
	 */
public static boolean moveFile(File source, File dest) {
    boolean ok = false;
    if ((dest.exists() && dest.canWrite()) || (!dest.exists() && dest.getParentFile().canWrite())) {
        OutputStream fos = null;
        InputStream fis = null;
        try {
            fos = new FileOutputStream(dest);
            fis = new FileInputStream(source);
            ok = copyStream(32768, null, fis, fos, false);
        } catch (IOException ioe) {
            Log.log(Log.WARNING, IOUtilities.class, "Error moving file: " + ioe + " : " + ioe.getMessage());
        } finally {
            closeQuietly(fos);
            closeQuietly(fis);
        }
        if (ok)
            source.delete();
    }
    return ok;
}