//{{{ focusGained() method
@Override
public void focusGained(FocusEvent evt) {
    if (bufferChanging)
        return;
    if (match != null) {
        if (caretLine < match.startLine)
            invalidateLineRange(caretLine, match.endLine);
        else
            invalidateLineRange(match.startLine, caretLine);
    } else
        invalidateLine(caretLine);
    focusedComponent = TextArea.this;
//}}}
}