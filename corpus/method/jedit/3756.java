public void paint(Graphics g) {
    int currentWidth = (int) list.getFontMetrics(list.getFont()).getStringBounds(text, g).getWidth();
    this.width = Math.max(this.width, currentWidth);
    g.setColor(getBackground());
    g.fillRect(0, 0, getWidth(), getHeight());
    g.setColor(getForeground());
    g.drawString(text, borderWidth, baseline);
}