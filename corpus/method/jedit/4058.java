public void propertiesChanged() {
    // retarded GTK look and feel!
    Font font = new JLabel().getFont();
    //UIManager.getFont("Label.font");
    FontMetrics fm = cmp.getFontMetrics(font);
    Dimension dim = new Dimension(Math.max(fm.charWidth('r'), fm.charWidth('R')) + 1, fm.getHeight());
    cmp.setPreferredSize(dim);
    cmp.setMaximumSize(dim);
}