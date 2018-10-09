//}}}
//{{{ replaceOne() method
/**
	 * Replace one occurrence of the search string with the
	 * replacement string.
	 */
private static int replaceOne(View view, JEditBuffer buffer, SearchMatcher.Match occur, int offset, CharSequence found, boolean smartCaseReplace) throws Exception {
    String subst = replaceOne(view, buffer, occur, found);
    if (smartCaseReplace && ignoreCase) {
        int strCase = TextUtilities.getStringCase(found);
        if (strCase == TextUtilities.LOWER_CASE)
            subst = subst.toLowerCase();
        else if (strCase == TextUtilities.UPPER_CASE)
            subst = subst.toUpperCase();
        else if (strCase == TextUtilities.TITLE_CASE)
            subst = TextUtilities.toTitleCase(subst);
    }
    if (subst != null) {
        int start = offset + occur.start;
        int end = offset + occur.end;
        if (end - start > 0)
            buffer.remove(start, end - start);
        buffer.insert(start, subst);
        return subst.length();
    } else
        return -1;
}