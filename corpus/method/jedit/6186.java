//}}}
//{{{ getSelection() method
/**
	 * Returns an array of selection objects pointing to the occurrences
	 * of the search term on the current line. The buffer must be opened
	 * first.
	 * @since jEdit 4.2pre5
	 */
public Selection[] getSelection() {
    if (buffer == null)
        return null;
    Selection[] returnValue = new Selection[occurCount];
    Occur o = occur;
    int i = 0;
    while (o != null) {
        int start = o.startPos.getOffset();
        int end = o.endPos.getOffset();
        Selection.Range s = new Selection.Range(start, end);
        returnValue[i++] = s;
        o = o.next;
    }
    return returnValue;
}