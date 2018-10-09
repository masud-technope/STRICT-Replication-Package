//}}}
//{{{ setRegexp() method
/**
	 * Sets the state of the regular expression flag.
	 * @param regexp True if regular expression searches should be
	 * performed
	 */
public static void setRegexp(boolean regexp) {
    if (regexp == SearchAndReplace.regexp)
        return;
    SearchAndReplace.regexp = regexp;
    if (regexp && reverse)
        reverse = false;
    matcher = null;
    EditBus.send(new SearchSettingsChanged(null));
}