//{{{ paintVertBorder() method
private void paintVertBorder(Graphics g, int x, int y, int height) {
    g.setColor(color3);
    g.fillRect(x, y, SPLITTER_WIDTH, height);
    for (int i = 0; i < height / 4 - 1; i++) {
        g.setColor(color1);
        g.drawLine(x + 3, y + (i << 2) + 2, x + 3, y + (i << 2) + 2);
        g.setColor(color2);
        g.drawLine(x + 4, y + (i << 2) + 3, x + 4, y + (i << 2) + 3);
        g.setColor(color1);
        g.drawLine(x + 5, y + (i << 2) + 4, x + 5, y + (i << 2) + 4);
        g.setColor(color2);
        g.drawLine(x + 6, y + (i << 2) + 5, x + 6, y + (i << 2) + 5);
    }
//}}}
}