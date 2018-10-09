//}}}
//{{{ getLineEndOffset() method
public final int getLineEndOffset(int line) {
    if (gapLine != -1 && line >= gapLine)
        return endOffsets[line] + gapWidth;
    else
        return endOffsets[line];
}