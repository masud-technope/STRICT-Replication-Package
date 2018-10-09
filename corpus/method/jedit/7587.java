//}}}
//{{{ closeStream() method
/**
	 * Closes the log stream. Should be done before your program exits.
	 * @since jEdit 2.6pre5
	 */
public static void closeStream() {
    if (stream != null) {
        try {
            stream.close();
            stream = null;
        } catch (IOException io) {
            io.printStackTrace(realErr);
        }
    }
}