@Override
public void paintScreenLineRange(Graphics2D gfx, int firstLine, int lastLine, int[] physicalLines, int[] start, int[] end, int y, int lineHeight) {
    if (textArea.wrapMargin != 0 && !textArea.wrapToWidth && isWrapGuidePainted()) {
        gfx.setColor(getWrapGuideColor());
        int x = textArea.getHorizontalOffset() + textArea.wrapMargin;
        gfx.drawLine(x, y, x, y + (lastLine - firstLine + 1) * lineHeight);
    }
}