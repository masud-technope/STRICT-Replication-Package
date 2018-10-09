//}}}
//{{{ paintScreenLineRange() method
void paintScreenLineRange(TextArea textArea, Graphics2D gfx, int firstLine, int lastLine, int y, int lineHeight) {
    try {
        int[] physicalLines = new int[lastLine - firstLine + 1];
        int[] start = new int[physicalLines.length];
        int[] end = new int[physicalLines.length];
        for (int i = 0; i < physicalLines.length; i++) {
            int screenLine = i + firstLine;
            ChunkCache.LineInfo lineInfo = textArea.chunkCache.getLineInfo(screenLine);
            if (lineInfo.physicalLine == -1)
                physicalLines[i] = -1;
            else {
                physicalLines[i] = lineInfo.physicalLine;
                start[i] = textArea.getScreenLineStartOffset(screenLine);
                end[i] = textArea.getScreenLineEndOffset(screenLine);
            }
        }
        paintScreenLineRange(gfx, firstLine, lastLine, physicalLines, start, end, y, lineHeight);
    } catch (Exception e) {
        Log.log(Log.ERROR, this, "Error repainting line" + " range {" + firstLine + ',' + lastLine + "}:");
        Log.log(Log.ERROR, this, e);
    }
}