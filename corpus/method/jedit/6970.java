@Override
protected void paintFoldShape(Graphics2D gfx, int top, int bottom) {
    gfx.drawRect(1, top, 8, (bottom - top));
}