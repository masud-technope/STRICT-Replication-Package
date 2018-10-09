public void paintIcon(Component c, Graphics g, int x, int y) {
    Graphics2D g2d = (Graphics2D) g.create();
    g2d.setRenderingHints(renderingHints);
    for (int i = 0; i < 4; i++) {
        if (rank > i)
            g2d.setColor(UIManager.getColor("Label.foreground"));
        else
            g2d.setColor(UIManager.getColor("Label.disabledForeground"));
        g2d.fillOval(x + i * 10, y, 9, 9);
    }
}