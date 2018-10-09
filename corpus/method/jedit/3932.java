//}}}
//{{{ move() method
public void move(String newPosition) {
    int orientation = JSplitPane.HORIZONTAL_SPLIT;
    if (newPosition.equals(DockableWindowManager.LEFT) || newPosition.equals(DockableWindowManager.RIGHT))
        orientation = JSplitPane.VERTICAL_SPLIT;
    splitPane.setOrientation(orientation);
    revalidate();
}