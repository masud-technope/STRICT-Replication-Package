/**
	 * Copy an input stream to an output stream.
	 *
	 * @param bufferSize the size of the buffer
	 * @param progress the progress observer it could be null
	 * @param in the input stream
	 * @param out the output stream
	 * @param canStop if true, the copy can be stopped by interrupting the thread
	 * @return <code>true</code> if the copy was done, <code>false</code> if it was interrupted
	 * @throws IOException  IOException If an I/O error occurs
	 */
public static boolean copyStream(int bufferSize, @Nullable ProgressObserver progress, InputStream in, OutputStream out, boolean canStop) throws IOException {
    return copyStream(bufferSize, progress, null, in, out, canStop);
}