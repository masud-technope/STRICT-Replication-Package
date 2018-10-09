//{{{ focusLost() method
@Override
public void focusLost(FocusEvent evt) {
    if (!isShowing())
        return;
    if (match != null) {
        if (caretLine < match.startLine)
            invalidateLineRange(caretLine, match.endLine);
        else
            invalidateLineRange(match.startLine, caretLine);
    } else
        invalidateLine(caretLine);
//}}}
}