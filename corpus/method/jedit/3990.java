//{{{ propertiesChanged() method
public void propertiesChanged() {
    // retarded GTK look and feel!
    Font font = new JLabel().getFont();
    //UIManager.getFont("Label.font");
    FontMetrics fm = bufferSetLabel.getFontMetrics(font);
    Dimension dim = new Dimension(Math.max(fm.charWidth('E'), Math.max(fm.charWidth('V'), fm.charWidth('G'))), fm.getHeight());
    bufferSetLabel.setPreferredSize(dim);
    bufferSetLabel.setMaximumSize(dim);
//}}}
}