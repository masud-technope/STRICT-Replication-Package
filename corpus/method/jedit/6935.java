//{{{ getText() method
@Override
void getText(JEditBuffer buffer, StringBuilder buf) {
    int start = getStartColumn(buffer);
    int end = getEndColumn(buffer);
    for (int i = startLine; i <= endLine; i++) {
        int lineStart = buffer.getLineStartOffset(i);
        int lineLen = buffer.getLineLength(i);
        int rectStart = buffer.getOffsetOfVirtualColumn(i, start, null);
        if (rectStart == -1)
            rectStart = lineLen;
        int rectEnd = buffer.getOffsetOfVirtualColumn(i, end, null);
        if (rectEnd == -1)
            rectEnd = lineLen;
        if (rectEnd < rectStart)
            System.err.println(i + ":::" + start + ':' + end + " ==> " + rectStart + ':' + rectEnd);
        buf.append(buffer.getText(lineStart + rectStart, rectEnd - rectStart));
        if (i != endLine)
            buf.append('\n');
    }
//}}}
}