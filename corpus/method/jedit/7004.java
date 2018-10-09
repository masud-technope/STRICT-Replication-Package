public void paintValidLine(Graphics2D gfx, int screenLine, int physicalLine, int start, int end, int y) {
    if (!textArea.getPainter().isStructureHighlightEnabled())
        return;
    Match match = textArea.getStructureMatch();
    if (match != null) {
        paintHighlight(gfx, screenLine, start, end, y, match);
    }
}