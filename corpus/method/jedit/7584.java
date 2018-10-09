/**
	 * Method that will close an {@link ObjectOutput} ignoring it if it is null and ignoring exceptions.
	 * @param out the closeable to close.
	 * @since jEdit 5.1pre1
	 */
public void closeQuietly(@Nullable ObjectOutput out) {
    if (out != null) {
        try {
            out.close();
        } catch (IOException e) {
        }
    }
}