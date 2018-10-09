//}}}
//{{{ getFoldModes() method
/**
	 * Returns an array containing the names of all registered fold
	 * handlers.
	 *
	 * @since jEdit 4.0pre6
	 */
public static String[] getFoldModes() {
    return foldHandlerProvider.getFoldModes();
}