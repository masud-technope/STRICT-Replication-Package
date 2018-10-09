//}}}
//{{{ apply() method
public void apply(JEditBuffer buffer, int thisLineIndex, int prevLineIndex, int prevPrevLineIndex, List<IndentAction> indentActions) {
    int index;
    if (aligned)
        index = thisLineIndex;
    else
        index = prevLineIndex;
    if (index == -1)
        return;
    CharSequence lineText = buffer.getLineSegment(index);
    int offset;
    for (offset = lineText.length() - 1; offset >= 0; offset--) {
        if (lineText.charAt(offset) == closeBracket)
            break;
    }
    if (offset == -1)
        return;
    int closeCount = getBrackets(buffer, index).closeCount;
    if (closeCount != 0) {
        AlignBracket alignBracket = new AlignBracket(buffer, index, offset);
        /*
			Consider the following Common Lisp code (with one more opening
			bracket than closing):

			(defun emit-push-long (arg)
			  (cond ((eql arg 0)
			      (emit 'lconst_0))
			    ((eql arg 1)
			      (emit 'lconst_1)))

			even though we have a closing bracket match on line 3,
			the next line must be indented relative to the
			corresponding opening bracket from line 1.
			*/
        int openLine = alignBracket.getOpenBracketLine();
        if (openLine != -1) {
            int column = alignBracket.getOpenBracketColumn();
            alignBracket.setExtraIndent(getBrackets(buffer, openLine, 0, column).openCount);
        }
        indentActions.add(alignBracket);
    }
}