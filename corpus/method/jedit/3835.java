//{{{ paintHorizBorder() method
private void paintHorizBorder(Graphics g, int x, int y, int width) {
    g.setColor(color3);
    g.fillRect(x, y, width, SPLITTER_WIDTH);
    for (int i = 0; i < width / 4 - 1; i++) {
        g.setColor(color1);
        g.drawLine(x + (i << 2) + 2, y + 3, x + (i << 2) + 2, y + 3);
        g.setColor(color2);
        g.drawLine(x + (i << 2) + 3, y + 4, x + (i << 2) + 3, y + 4);
        g.setColor(color1);
        g.drawLine(x + (i << 2) + 4, y + 5, x + (i << 2) + 4, y + 5);
        g.setColor(color2);
        g.drawLine(x + (i << 2) + 5, y + 6, x + (i << 2) + 5, y + 6);
    }
//}}}
}