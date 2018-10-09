@Override
public void paintValidLine(Graphics2D gfx, int screenLine, int physicalLine, int start, int end, int y) {
    if (showPageBreak) {
        if (pages == null || pages.isEmpty()) {
            loadPageRanges();
            if (pages == null || pages.isEmpty()) {
                return;
            }
        }
        gfx.setColor(pageBreakColor);
        // - 1 so last page break isn't drawn
        for (int page = 1; page < pages.size(); page++) {
            Range range = pages.get(page);
            // the page break line drawn on it.
            if (range != null && range.getEnd() == physicalLine && textArea.getLineEndOffset(physicalLine) == end) {
                y += gfx.getFontMetrics().getHeight();
                gfx.drawLine(0, y, textArea.getPainter().getWidth(), y);
            }
        }
    }
}