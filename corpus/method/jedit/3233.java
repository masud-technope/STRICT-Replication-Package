//}}}
//{{{ setBounds() method
public void setBounds(int x, int y, int width, int height) {
    final String position = panel.getPosition();
    final int dimension = panel.getDimension();
    if (position.equals(DockableWindowManager.TOP) || position.equals(DockableWindowManager.BOTTOM)) {
        if (dimension != 0 && height <= PanelWindowContainer.SPLITTER_WIDTH)
            panel.show((DockableWindowManagerImpl.Entry) null);
        else
            panel.setDimension(height);
    } else {
        if (dimension != 0 && width <= PanelWindowContainer.SPLITTER_WIDTH)
            panel.show((DockableWindowManagerImpl.Entry) null);
        else
            panel.setDimension(width);
    }
    super.setBounds(x, y, width, height);
}