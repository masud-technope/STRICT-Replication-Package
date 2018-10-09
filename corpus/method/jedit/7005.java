private int[] getOffsets(int screenLine, Match match) {
    int x1, x2;
    int matchStartLine = textArea.getScreenLineOfOffset(match.start);
    int matchEndLine = textArea.getScreenLineOfOffset(match.end);
    if (matchStartLine == screenLine) {
        x1 = match.start;
    } else {
        x1 = textArea.getScreenLineStartOffset(screenLine);
    }
    if (matchEndLine == screenLine) {
        x2 = match.end;
    } else {
        x2 = textArea.getScreenLineEndOffset(screenLine) - 1;
    }
    return new int[] { textArea.offsetToXY(x1).x, textArea.offsetToXY(x2).x };
}