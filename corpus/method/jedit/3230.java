//}}}
//{{{ getPreferredSize() method
public Dimension getPreferredSize() {
    final String position = panel.getPosition();
    final int dimension = panel.getDimension();
    if (panel.getCurrent() == null)
        return new Dimension(0, 0);
    else {
        if (position.equals(DockableWindowManager.TOP) || position.equals(DockableWindowManager.BOTTOM)) {
            if (dimension <= 0) {
                int height = super.getPreferredSize().height;
                panel.setDimension(height);
            }
            return new Dimension(0, dimension + PanelWindowContainer.SPLITTER_WIDTH);
        } else {
            if (dimension <= 0) {
                int width = super.getPreferredSize().width;
                panel.setDimension(width);
            }
            return new Dimension(dimension + PanelWindowContainer.SPLITTER_WIDTH, 0);
        }
    }
}