//}}}
//{{{ paintComponent() method
public void paintComponent(Graphics g) {
    if (!isSelected) {
        Color color = file.getColor();
        setForeground(color == null ? UIManager.getColor("Tree.foreground") : color);
    }
    super.paintComponent(g);
    if (openBuffer) {
        Font font = getFont();
        FontMetrics fm = getFontMetrics(font);
        int x, y;
        if (getIcon() == null) {
            x = 0;
            y = fm.getAscent() + 2;
        } else {
            x = getIcon().getIconWidth() + getIconTextGap();
            y = Math.max(fm.getAscent() + 2, 16);
        }
        Insets border = getBorder().getBorderInsets(this);
        x += border.left;
        g.setColor(getForeground());
        g.drawLine(x, y, x + fm.stringWidth(getText()), y);
    }
}