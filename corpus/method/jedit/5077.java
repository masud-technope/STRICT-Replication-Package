//{{{ paint() method
public void paint(Graphics g) {
    super.paint(g);
    String shortcut = getShortcut();
    if (shortcut != null) {
        Graphics2D g2 = (Graphics2D) g;
        g.setFont(acceleratorFont);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(getModel().isArmed() ? acceleratorSelectionForeground : acceleratorForeground);
        FontMetrics fm = g.getFontMetrics();
        Insets insets = getInsets();
        g.drawString(shortcut, getWidth() - (fm.stringWidth(shortcut) + insets.right + insets.left + 5), fm.getAscent() + insets.top);
    }
//}}}
}