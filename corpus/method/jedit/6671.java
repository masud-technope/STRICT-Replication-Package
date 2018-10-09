//}}}
//{{{  isLineWithinThisBlock() method
public int isLineWithinThisBlock(int line) {
    if (line < startLine) {
        return line - startLine;
    } else if (line > endLine) {
        return line - endLine;
    } else {
        return 0;
    }
}