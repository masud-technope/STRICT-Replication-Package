//}}}
//{{{ copyStream() methods
/**
	 * Copy an input stream to an output stream.
	 *
	 * @param bufferSize the size of the buffer
	 * @param progress the progress observer it could be null
	 * @param progressPrefix the progress prefix, it could be null
	 * @param in the input stream
	 * @param out the output stream
	 * @param canStop if true, the copy can be stopped by interrupting the thread
	 * @return <code>true</code> if the copy was done, <code>false</code> if it was interrupted
	 * @throws IOException  IOException If an I/O error occurs
	 */
public static boolean copyStream(int bufferSize, @Nullable ProgressObserver progress, String progressPrefix, InputStream in, OutputStream out, boolean canStop) throws IOException {
    byte[] buffer = new byte[bufferSize];
    int n;
    long copied = 0L;
    while (-1 != (n = in.read(buffer))) {
        out.write(buffer, 0, n);
        copied += n;
        if (progress != null) {
            String progressMessage = StandardUtilities.formatFileSize(copied);
            if (progressPrefix != null) {
                progressMessage = String.format("%s (%s)", progressPrefix, progressMessage);
            }
            progress.setStatus(progressMessage);
            progress.setValue(copied);
        }
        if (canStop && Thread.interrupted())
            return false;
    }
    return true;
}