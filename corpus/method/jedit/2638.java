//}}}
//{{{ moveGap() method
private void moveGap(int newGapLine, int newGapWidth, String method) {
    if (gapLine == -1)
        gapWidth = newGapWidth;
    else if (newGapLine == -1) {
        if (gapWidth != 0) {
            if (Debug.OFFSET_DEBUG && gapLine != lineCount)
                Log.log(Log.DEBUG, this, method + ": update from " + gapLine + " to " + lineCount + " width " + gapWidth);
            for (int i = gapLine; i < lineCount; i++) setLineEndOffset(i, getLineEndOffset(i));
        }
        gapWidth = newGapWidth;
    } else if (newGapLine < gapLine) {
        if (gapWidth != 0) {
            if (Debug.OFFSET_DEBUG && newGapLine != gapLine)
                Log.log(Log.DEBUG, this, method + ": update from " + newGapLine + " to " + gapLine + " width " + gapWidth);
            for (int i = newGapLine; i < gapLine; i++) setLineEndOffset(i, getLineEndOffset(i) - gapWidth);
        }
        gapWidth += newGapWidth;
    } else //if(newGapLine >= gapLine)
    {
        if (gapWidth != 0) {
            if (Debug.OFFSET_DEBUG && gapLine != newGapLine)
                Log.log(Log.DEBUG, this, method + ": update from " + gapLine + " to " + newGapLine + " width " + gapWidth);
            for (int i = gapLine; i < newGapLine; i++) setLineEndOffset(i, getLineEndOffset(i));
        }
        gapWidth += newGapWidth;
    }
    if (newGapLine == lineCount)
        gapLine = -1;
    else
        gapLine = newGapLine;
}