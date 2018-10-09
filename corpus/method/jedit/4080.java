@Override
public void propertiesChanged() {
    // retarded GTK look and feel!
    Font font = new JLabel().getFont();
    //UIManager.getFont("Label.font");
    FontMetrics fm = multiSelect.getFontMetrics(font);
    Dimension dim = new Dimension(Math.max(fm.charWidth('m'), fm.charWidth('M')) + 1, fm.getHeight());
    multiSelect.setPreferredSize(dim);
    multiSelect.setMaximumSize(dim);
}