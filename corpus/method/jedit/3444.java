@Override
public Dimension getPreferredScrollableViewportSize() {
    FontMetrics metrics = getFontMetrics(getFont());
    int width = 80 * metrics.charWidth('X');
    int height = 25 * metrics.getHeight();
    return new Dimension(width, height);
}