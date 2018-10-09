//}}}
//{{{ getOpenBracketCount() method
private int getOpenBracketCount(JEditBuffer buffer, int line) {
    if (line == -1)
        return 0;
    else
        return getBrackets(buffer, line).openCount;
}