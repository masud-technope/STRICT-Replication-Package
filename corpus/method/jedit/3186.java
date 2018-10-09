//}}}
//{{{ fitInScreen() method
private static Point fitInScreen(Point p, Window w, int lineHeight) {
    Rectangle screenSize = w.getGraphicsConfiguration().getBounds();
    if (p.y + w.getHeight() >= screenSize.height)
        p.y = p.y - w.getHeight() - lineHeight;
    return p;
}