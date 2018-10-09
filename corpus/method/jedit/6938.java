//{{{ getEnd() method
@Override
public int getEnd(JEditBuffer buffer, int line) {
    return getColumnOnOtherLine(buffer, line, getEndColumn(buffer));
//}}}
}