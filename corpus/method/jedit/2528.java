//}}}
//{{{ parseBufferLocalProperties() method
protected void parseBufferLocalProperties() {
    int maxRead = 10000;
    int lineCount = getLineCount();
    int lastLine = Math.min(9, lineCount - 1);
    int max = Math.min(maxRead, getLineEndOffset(lastLine) - 1);
    parseBufferLocalProperties(getSegment(0, max));
    // first line for last 10 lines, make sure not to overlap
    // with the first 10
    int firstLine = Math.max(lastLine + 1, lineCount - 10);
    if (firstLine < lineCount) {
        int firstLineStartOffset = getLineStartOffset(firstLine);
        int length = getLineEndOffset(lineCount - 1) - (firstLineStartOffset + 1);
        if (length > maxRead) {
            firstLineStartOffset += length - maxRead;
            length = maxRead;
        }
        parseBufferLocalProperties(getSegment(firstLineStartOffset, length));
    }
}