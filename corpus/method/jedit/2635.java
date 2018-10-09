//}}}
//{{{ contentInserted() method
public void contentInserted(int startLine, int offset, int numLines, int length, IntegerArray endOffsets) {
    int endLine = startLine + numLines;
    //{{{ Update line info and line context arrays
    if (numLines > 0) {
        //moveGap(-1,0,"contentInserted");
        lineCount += numLines;
        if (this.endOffsets.length <= lineCount) {
            int[] endOffsetsN = new int[(lineCount + 1) * 2];
            System.arraycopy(this.endOffsets, 0, endOffsetsN, 0, this.endOffsets.length);
            this.endOffsets = endOffsetsN;
        }
        if (foldLevels.length <= lineCount) {
            short[] foldLevelsN = new short[(lineCount + 1) * 2];
            System.arraycopy(foldLevels, 0, foldLevelsN, 0, foldLevels.length);
            foldLevels = foldLevelsN;
        }
        if (lineContext.length <= lineCount) {
            TokenMarker.LineContext[] lineContextN = new TokenMarker.LineContext[(lineCount + 1) * 2];
            System.arraycopy(lineContext, 0, lineContextN, 0, lineContext.length);
            lineContext = lineContextN;
        }
        System.arraycopy(this.endOffsets, startLine, this.endOffsets, endLine, lineCount - endLine);
        System.arraycopy(foldLevels, startLine, foldLevels, endLine, lineCount - endLine);
        System.arraycopy(lineContext, startLine, lineContext, endLine, lineCount - endLine);
        if (startLine <= gapLine)
            gapLine += numLines;
        else if (gapLine != -1)
            offset -= gapWidth;
        for (int i = 0; i < numLines; i++) {
            this.endOffsets[startLine + i] = (offset + endOffsets.get(i));
            foldLevels[startLine + i] = 0;
        }
    //}}}
    }
    if (firstInvalidLineContext == -1 || firstInvalidLineContext > startLine)
        firstInvalidLineContext = startLine;
    if (firstInvalidFoldLevel == -1 || firstInvalidFoldLevel > startLine)
        firstInvalidFoldLevel = startLine;
    moveGap(endLine, length, "contentInserted");
}