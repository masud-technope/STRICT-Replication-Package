//{{{ getStart() method
@Override
public int getStart(JEditBuffer buffer, int line) {
    if (line == startLine)
        return start;
    else
        return buffer.getLineStartOffset(line);
//}}}
}