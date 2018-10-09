//}}}
//{{{ recalculateVisibleLines() method
/**
	 * Recalculate visible lines.
	 * This is called when the TextArea geometry is changed or when the font is changed.
	 */
void recalculateVisibleLines() {
    LineInfo[] newLineInfo = new LineInfo[textArea.getVisibleLines()];
    int start;
    if (lineInfo == null)
        start = 0;
    else {
        start = Math.min(lineInfo.length, newLineInfo.length);
        System.arraycopy(lineInfo, 0, newLineInfo, 0, start);
    }
    for (int i = start; i < newLineInfo.length; i++) newLineInfo[i] = new LineInfo();
    lineInfo = newLineInfo;
    lastScreenLine = lastScreenLineP = -1;
}