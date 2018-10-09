//}}}
//{{{ replaceInSelection() method
private static int replaceInSelection(View view, TextArea textArea, Buffer buffer, SearchMatcher matcher, boolean smartCaseReplace, Selection s) throws Exception {
    /* if an occurence occurs at the
		beginning of the selection, the
		selection start will get moved.
		this sucks, so we hack to avoid it. */
    int start = s.getStart();
    int returnValue;
    if (s instanceof Selection.Range) {
        returnValue = _replace(view, buffer, matcher, s.getStart(), s.getEnd(), smartCaseReplace);
        textArea.removeFromSelection(s);
        textArea.addToSelection(new Selection.Range(start, s.getEnd()));
    } else if (s instanceof Selection.Rect) {
        Selection.Rect rect = (Selection.Rect) s;
        int startCol = rect.getStartColumn(buffer);
        int endCol = rect.getEndColumn(buffer);
        returnValue = 0;
        for (int j = s.getStartLine(); j <= s.getEndLine(); j++) {
            returnValue += _replace(view, buffer, matcher, getColumnOnOtherLine(buffer, j, startCol), getColumnOnOtherLine(buffer, j, endCol), smartCaseReplace);
        }
        textArea.addToSelection(new Selection.Rect(start, s.getEnd()));
    } else
        throw new RuntimeException("Unsupported: " + s);
    return returnValue;
}