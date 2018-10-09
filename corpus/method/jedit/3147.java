public void paintIcon(Component c, Graphics g, int x, int y) {
    if (color == null)
        return;
    g.setColor(color);
    g.fillRect(x, y, getIconWidth(), getIconHeight());
    g.setColor(color.darker());
    g.drawRect(x, y, getIconWidth() - 1, getIconHeight() - 1);
}