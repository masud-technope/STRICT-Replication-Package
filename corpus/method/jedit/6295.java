//}}}
//{{{ replace() method
/**
	 * Replaces text in the specified range with the replacement string.
	 * @param view The view
	 * @param buffer The buffer
	 * @param start The start offset
	 * @param end The end offset
	 * @return True if the operation was successful, false otherwise
	 */
public static boolean replace(View view, Buffer buffer, int start, int end) {
    if (!buffer.isEditable())
        return false;
    // component that will parent any dialog boxes
    Component comp = SearchDialog.getSearchDialog(view);
    if (comp == null)
        comp = view;
    boolean smartCaseReplace = getSmartCaseReplace();
    try {
        buffer.beginCompoundEdit();
        SearchMatcher matcher = getSearchMatcher();
        if (matcher == null)
            return false;
        initReplace();
        int retVal = 0;
        retVal += _replace(view, buffer, matcher, start, end, smartCaseReplace);
        if (retVal != 0)
            return true;
    } catch (Exception e) {
        handleError(comp, e);
    } finally {
        buffer.endCompoundEdit();
    }
    return false;
}