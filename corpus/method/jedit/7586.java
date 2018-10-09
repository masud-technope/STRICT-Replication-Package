//{{{ flushStream() method
/**
	 * Flushes the log stream.
	 * @since jEdit 2.6pre5
	 */
public static void flushStream() {
    if (stream != null) {
        try {
            stream.flush();
        } catch (IOException io) {
            io.printStackTrace(realErr);
        }
    }
}