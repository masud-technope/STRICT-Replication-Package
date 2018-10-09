private void paintHighlight(Graphics gfx, int screenLine, int start, int end, int y, Match match) {
    if (!textArea.isStructureHighlightVisible())
        return;
    if (match.start >= end || match.end < start) {
        return;
    }
    int matchStartLine = textArea.getScreenLineOfOffset(match.start);
    int matchEndLine = textArea.getScreenLineOfOffset(match.end);
    int height = Math.min(textArea.getPainter().getLineHeight(), textArea.getPainter().getFontHeight());
    y += Math.max(textArea.getPainter().getLineExtraSpacing(), 0);
    int[] offsets = getOffsets(screenLine, match);
    int x1 = offsets[0];
    int x2 = offsets[1];
    gfx.setColor(textArea.getPainter().getStructureHighlightColor());
    gfx.drawLine(x1, y, x1, y + height - 1);
    gfx.drawLine(x2, y, x2, y + height - 1);
    if (matchStartLine == screenLine || screenLine == 0)
        gfx.drawLine(x1, y, x2, y);
    else {
        offsets = getOffsets(screenLine - 1, match);
        int prevX1 = offsets[0];
        int prevX2 = offsets[1];
        gfx.drawLine(Math.min(x1, prevX1), y, Math.max(x1, prevX1), y);
        gfx.drawLine(Math.min(x2, prevX2), y, Math.max(x2, prevX2), y);
    }
    if (matchEndLine == screenLine) {
        gfx.drawLine(x1, y + height - 1, x2, y + height - 1);
    }
}