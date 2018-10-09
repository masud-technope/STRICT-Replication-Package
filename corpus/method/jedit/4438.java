//}}}
//{{{ getBrackets() method
public Brackets getBrackets(JEditBuffer buffer, int lineIndex) {
    return getBrackets(buffer, lineIndex, 0, buffer.getLineLength(lineIndex));
}