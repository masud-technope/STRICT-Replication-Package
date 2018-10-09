//{{{ propertiesChanged() method
public void propertiesChanged() {
    // retarded GTK look and feel!
    Font font = new JLabel().getFont();
    //UIManager.getFont("Label.font");
    FontMetrics fm = lineSep.getFontMetrics(font);
    Dimension dim = new Dimension(Math.max(Math.max(fm.charWidth('U'), fm.charWidth('W')), fm.charWidth('M')) + 1, fm.getHeight());
    lineSep.setPreferredSize(dim);
    lineSep.setMaximumSize(dim);
//}}}
}