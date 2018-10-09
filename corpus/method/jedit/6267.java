//}}}
//{{{ getSmartCaseReplace() method
/**
	 * Returns if the replacement string will assume the same case as
	 * each specific occurrence of the search string.
	 * @since jEdit 4.2pre10
	 */
public static boolean getSmartCaseReplace() {
    return (replace != null && TextUtilities.getStringCase(replace) == TextUtilities.LOWER_CASE);
}