//}}}
//{{{ contentRemoved() method
public void contentRemoved(int startLine, int numLines) {
    int endLine = startLine + numLines;
    invalidateScreenLineCount(startLine);
    if (numLines > 0 && endLine != screenLines.length) {
        System.arraycopy(screenLines, endLine + 1, screenLines, startLine + 1, screenLines.length - endLine - 1);
    }
}