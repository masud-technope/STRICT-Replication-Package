//{{{ DockBorder constructor
 DockBorder(String position) {
    this.position = position;
    insets = new Insets(position.equals(DockableWindowManagerImpl.BOTTOM) ? SPLITTER_WIDTH : 0, position.equals(DockableWindowManagerImpl.RIGHT) ? SPLITTER_WIDTH : 0, position.equals(DockableWindowManagerImpl.TOP) ? SPLITTER_WIDTH : 0, position.equals(DockableWindowManagerImpl.LEFT) ? SPLITTER_WIDTH : 0);
//}}}
}