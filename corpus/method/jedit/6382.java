/**
		 * Returns the fold handler with the specified name, or null if
		 * there is no registered handler with that name.
		 * @param name The name of the desired fold handler
		 * @return the FoldHandler or null if it doesn't exist
		 * @since jEdit 4.3pre10
		 */
@Override
public FoldHandler getFoldHandler(String name) {
    FoldHandler handler = (FoldHandler) getService(SERVICE, name);
    return handler;
}