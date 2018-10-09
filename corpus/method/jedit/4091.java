public void propertiesChanged() {
    // retarded GTK look and feel!
    Font font = new JLabel().getFont();
    //UIManager.getFont("Label.font");
    FontMetrics fm = rectSelect.getFontMetrics(font);
    Dimension dim = new Dimension(Math.max(fm.charWidth('r'), fm.charWidth('R')) + 1, fm.getHeight());
    rectSelect.setPreferredSize(dim);
    rectSelect.setMaximumSize(dim);
}