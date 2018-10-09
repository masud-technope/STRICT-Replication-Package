public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
    g.translate(x + w - WIDTH, y - 1);
    //if(c.isEnabled())
    //{
    //	// vertical separation line
    //	g.setColor(UIManager.getColor("controlDkShadow"));
    //	g.drawLine(0,0,0,h);
    //}
    // down arrow
    int w2 = WIDTH / 2;
    int h2 = h / 2;
    g.setColor(UIManager.getColor(c.isEnabled() && ((HistoryTextField) c).getModel() != null ? "TextField.foreground" : "TextField.disabledForeground"));
    g.drawLine(w2 - 5, h2 - 2, w2 + 4, h2 - 2);
    g.drawLine(w2 - 4, h2 - 1, w2 + 3, h2 - 1);
    g.drawLine(w2 - 3, h2, w2 + 2, h2);
    g.drawLine(w2 - 2, h2 + 1, w2 + 1, h2 + 1);
    g.drawLine(w2 - 1, h2 + 2, w2, h2 + 2);
    g.translate(-(x + w - WIDTH), -(y - 1));
}