//}}}
//{{{ setReplaceString() method
/**
	 * Sets the current replacement string.
	 * @param replace The new replacement string
	 */
public static void setReplaceString(String replace) {
    if (replace.equals(SearchAndReplace.replace))
        return;
    SearchAndReplace.replace = replace;
    EditBus.send(new SearchSettingsChanged(null));
}