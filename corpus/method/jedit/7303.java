//{{{ paintBorder() method
public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    g.translate(x, y);
    g.setColor(MetalLookAndFeel.getControlDarkShadow());
    g.drawRect(0, 0, width - 2, height - 2);
    g.setColor(MetalLookAndFeel.getControlHighlight());
    g.drawLine(width - 1, 1, width - 1, height - 1);
    g.drawLine(1, height - 1, width - 1, height - 1);
    g.setColor(MetalLookAndFeel.getControl());
    g.drawLine(width - 2, 2, width - 2, 2);
    g.drawLine(1, height - 2, 1, height - 2);
    g.translate(-x, -y);
}