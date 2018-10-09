//{{{ getToolTipText() method
public final String getToolTipText(MouseEvent evt) {
    TreePath path = getPathForLocation(evt.getX(), evt.getY());
    if (path != null) {
        Rectangle cellRect = getPathBounds(path);
        if (cellRect != null && !cellRectIsVisible(cellRect))
            return path.getLastPathComponent().toString();
    }
    return null;
//}}}
}