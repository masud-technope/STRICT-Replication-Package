//}}}
//{{{ getSelectionPivotLine() method
/*
	 * See getSelectionPivotCaret for an explanation of this function
	 */
private int getSelectionPivotLine() {
    int c = textArea.caret;
    int cl = textArea.caretLine;
    if (textArea.getSelectionCount() != 1)
        return cl;
    Selection s = textArea.getSelection(0);
    cl = (c == s.start ? s.endLine : c == s.end ? s.startLine : cl);
    return cl;
}