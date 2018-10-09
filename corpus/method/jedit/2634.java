//}}}
//{{{ _contentInserted() method
public void _contentInserted(IntegerArray endOffsets) {
    gapLine = -1;
    gapWidth = 0;
    firstInvalidLineContext = firstInvalidFoldLevel = 0;
    lineCount = endOffsets.getSize();
    this.endOffsets = endOffsets.getArray();
    foldLevels = new short[lineCount];
    lineContext = new TokenMarker.LineContext[lineCount];
}