@Override
protected void paintFoldShape(Graphics2D gfx, int top, int bottom) {
    gfx.drawArc(1, top, 8, (bottom - top), 0, 360);
}