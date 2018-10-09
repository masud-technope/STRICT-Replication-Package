//{{{ getStart() method
@Override
public int getStart(JEditBuffer buffer, int line) {
    return getColumnOnOtherLine(buffer, line, getStartColumn(buffer));
//}}}
}