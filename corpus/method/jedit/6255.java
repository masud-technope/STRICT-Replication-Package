//}}}
//{{{ setIgnoreCase() method
/**
	 * Sets the ignore case flag.
	 * @param ignoreCase True if searches should be case insensitive,
	 * false otherwise
	 */
public static void setIgnoreCase(boolean ignoreCase) {
    if (ignoreCase == SearchAndReplace.ignoreCase)
        return;
    SearchAndReplace.ignoreCase = ignoreCase;
    matcher = null;
    EditBus.send(new SearchSettingsChanged(null));
}