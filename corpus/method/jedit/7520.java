//}}}
//{{{ isInsideScreen() method
private static boolean isInsideScreen(View parent, Rectangle r) {
    Rectangle bounds;
    if (parent == null)
        bounds = GenericGUIUtilities.getScreenBounds();
    else
        bounds = parent.getGraphicsConfiguration().getBounds();
    int minWidth = jEdit.getIntegerProperty("view.minStartupWidth");
    int minHeight = jEdit.getIntegerProperty("view.minStartupHeight");
    return // right edge at minWidth pixels on the right of the left bound
    r.x + r.width > bounds.x + minWidth && // left edge at minWidth pixels on the left of the right bound
    r.x < bounds.x + bounds.width - minWidth && // bottom edge at minHeight pixels under the top bound
    r.y + r.height > bounds.y + minHeight && // top edge at minHeight pixels on the top of the bottom bound
    r.y < bounds.y + bounds.height - minHeight;
}