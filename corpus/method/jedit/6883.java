//}}}
//{{{ contentInserted() method
public void contentInserted(int startLine, int numLines) {
    int endLine = startLine + numLines;
    invalidateScreenLineCount(startLine);
    int lineCount = buffer.getLineCount();
    if (numLines > 0) {
        if (screenLines.length <= lineCount) {
            char[] screenLinesN = new char[((lineCount + 1) << 1)];
            System.arraycopy(screenLines, 0, screenLinesN, 0, screenLines.length);
            screenLines = screenLinesN;
        }
        System.arraycopy(screenLines, startLine, screenLines, endLine, lineCount - endLine);
        for (int i = 0; i < numLines; i++) screenLines[startLine + i] = 0;
    }
}