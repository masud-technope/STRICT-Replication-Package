//}}}
//{{{ contentRemoved() method
public void contentRemoved(int startLine, int offset, int numLines, int length) {
    int endLine = startLine + numLines;
    //{{{ Update line info and line context arrays
    if (numLines > 0) {
        if (startLine + numLines < gapLine)
            gapLine -= numLines;
        else if (startLine < gapLine)
            gapLine = startLine;
        lineCount -= numLines;
        System.arraycopy(endOffsets, endLine, endOffsets, startLine, lineCount - startLine);
        System.arraycopy(foldLevels, endLine, foldLevels, startLine, lineCount - startLine);
        System.arraycopy(lineContext, endLine, lineContext, startLine, lineCount - startLine);
    //}}}
    }
    if (firstInvalidLineContext == -1 || firstInvalidLineContext > startLine)
        firstInvalidLineContext = startLine;
    if (firstInvalidFoldLevel == -1 || firstInvalidFoldLevel > startLine)
        firstInvalidFoldLevel = startLine;
    moveGap(startLine, -length, "contentRemoved");
}