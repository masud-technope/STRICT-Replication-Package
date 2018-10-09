/**
		 * Returns an array containing the names of all registered fold
		 * handlers.
		 *
		 * @since jEdit 4.3pre10
		 */
@Override
public String[] getFoldModes() {
    String[] handlers = getServiceNames(SERVICE);
    Arrays.sort(handlers, new StandardUtilities.StringCompare<String>());
    return handlers;
}