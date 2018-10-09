/**
     * Paints the drop shadow border around the given component.
     * @param c - the component for which this border is being painted
     * @param g - the paint graphics
     * @param x - the x position of the painted border
     * @param y - the y position of the painted border
     * @param width - the width of the painted border
     * @param height - the height of the painted border
     */
public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    Color old_color = g.getColor();
    int x1, y1, x2, y2;
    g.setColor(_color);
    // outline the component with a 1-pixel wide line
    g.drawRect(x, y, width - _width - 1, height - _width - 1);
    // draw the drop shadow
    for (int i = 0; i <= _width; i++) {
        // bottom shadow
        x1 = x + _width;
        y1 = y + height - i;
        x2 = x + width;
        y2 = y1;
        g.drawLine(x1, y1, x2, y2);
        // right shadow
        x1 = x + width - _width + i;
        y1 = y + _width;
        x2 = x1;
        y2 = y + height;
        g.drawLine(x1, y1, x2, y2);
    }
    // container
    if (c.getParent() != null) {
        g.setColor(c.getParent().getBackground());
        for (int i = 0; i <= _width; i++) {
            x1 = x;
            y1 = y + height - i;
            x2 = x + _width;
            y2 = y1;
            g.drawLine(x1, y1, x2, y2);
            x1 = x + width - _width;
            y1 = y + i;
            x2 = x + width;
            y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }
        // add some slightly darker colored triangles
        g.setColor(g.getColor().darker());
        for (int i = 0; i < _width; i++) {
            // bottom left triangle
            x1 = x + i + 1;
            y1 = y + height - _width + i;
            x2 = x + _width;
            y2 = y1;
            g.drawLine(x1, y1, x2, y2);
            // top right triangle
            x1 = x + width - _width;
            y1 = y + i + 1;
            x2 = x1 + i;
            y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }
    }
    g.setColor(old_color);
}