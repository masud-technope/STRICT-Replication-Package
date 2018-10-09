//}}}
//{{{ getFoldHandler() method
/**
	 * Returns the fold handler with the specified name, or null if
	 * there is no registered handler with that name.
	 * @param name The name of the desired fold handler
	 * @since jEdit 4.0pre6
	 */
public static FoldHandler getFoldHandler(String name) {
    return foldHandlerProvider.getFoldHandler(name);
}