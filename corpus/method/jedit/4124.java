public void propertiesChanged() {
    // retarded GTK look and feel!
    Font font = new JLabel().getFont();
    //UIManager.getFont("Label.font");
    FontMetrics fm = wrap.getFontMetrics(font);
    Dimension dim = new Dimension(Math.max(Math.max(fm.charWidth('N'), fm.charWidth('H')), fm.charWidth('S')) + 1, fm.getHeight());
    wrap.setPreferredSize(dim);
    wrap.setMaximumSize(dim);
}