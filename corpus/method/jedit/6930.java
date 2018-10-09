//{{{ getEnd() method
@Override
public int getEnd(JEditBuffer buffer, int line) {
    if (line == endLine)
        return end;
    else
        return buffer.getLineEndOffset(line) - 1;
//}}}
}