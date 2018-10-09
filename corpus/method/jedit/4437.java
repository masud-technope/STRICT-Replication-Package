//}}}
//{{{ getBrackets() method
public Brackets getBrackets(JEditBuffer buffer, int lineIndex, int begin, int end) {
    LineScanner scanner = new LineScanner(begin, end);
    buffer.markTokens(lineIndex, scanner);
    return scanner.result;
}