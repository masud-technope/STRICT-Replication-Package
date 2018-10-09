/**
	 * Method that will close an {@link ObjectInput} ignoring it if it is null and ignoring exceptions.
	 *
	 * @param in the closeable to close.
	 * @since jEdit 5.1pre1
	 */
public void closeQuietly(@Nullable ObjectInput in) {
    if (in != null) {
        try {
            in.close();
        } catch (IOException e) {
        }
    }
}