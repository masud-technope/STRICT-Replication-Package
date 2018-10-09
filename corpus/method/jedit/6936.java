//}}}
//{{{ Private members
//{{{ getColumnOnOtherLine() method
private static int getColumnOnOtherLine(JEditBuffer buffer, int line, int col) {
    int returnValue = buffer.getOffsetOfVirtualColumn(line, col, null);
    if (returnValue == -1)
        return buffer.getLineEndOffset(line) - 1;
    else
        return buffer.getLineStartOffset(line) + returnValue;
//}}}
}