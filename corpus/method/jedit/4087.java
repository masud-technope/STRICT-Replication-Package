//{{{ propertiesChanged() method
public void propertiesChanged() {
    // retarded GTK look and feel!
    Font font = new JLabel().getFont();
    //UIManager.getFont("Label.font");
    FontMetrics fm = overwrite.getFontMetrics(font);
    Dimension dim = new Dimension(Math.max(fm.charWidth('o'), fm.charWidth('O')) + 1, fm.getHeight());
    overwrite.setPreferredSize(dim);
    overwrite.setMaximumSize(dim);
//}}}
}