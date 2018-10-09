//{{{ getFoldEndOffset() method
private int getFoldEndOffset(int line) {
    JEditBuffer buffer = textArea.getBuffer();
    int endLine;
    if ((line == buffer.getLineCount() - 1) || (textArea.displayManager.isLineVisible(line + 1))) {
        endLine = line;
    } else {
        int[] lines = buffer.getFoldAtLine(line);
        endLine = lines[1];
    }
    if (endLine == buffer.getLineCount() - 1)
        return buffer.getLineEndOffset(endLine) - 1;
    else
        return buffer.getLineEndOffset(endLine);
//}}}
}