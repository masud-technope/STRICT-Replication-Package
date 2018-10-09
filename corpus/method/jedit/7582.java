// }}}
//{{{ closeQuietly() methods
/**
	 * Method that will close a {@link java.io.Closeable} ignoring it if it is null and ignoring exceptions.
	 *
	 * @param closeable the closeable to close.
	 * @since jEdit 4.3pre8
	 */
public static void closeQuietly(@Nullable Closeable closeable) {
    if (closeable != null) {
        try {
            if (closeable instanceof Flushable) {
                ((Flushable) closeable).flush();
            }
        } catch (IOException e) {
        }
        try {
            closeable.close();
        } catch (IOException e) {
        }
    }
}