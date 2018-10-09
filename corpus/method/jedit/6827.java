// {{{ Private utilities
// Compute return value of getTextLocation() from (x, y).
private Rectangle getCaretRectangle(int x, int y) {
    TextAreaPainter painter = owner.getPainter();
    Point origin = painter.getLocationOnScreen();
    int height = painter.getLineHeight();
    return new Rectangle(origin.x + x, origin.y + y, 0, height);
}