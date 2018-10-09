//{{{ paintIcon() method
public void paintIcon(Component c, Graphics g, int x, int y) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setFont(font);
    AffineTransform oldTransform = g2d.getTransform();
    RenderingHints oldHints = g2d.getRenderingHints();
    g2d.setRenderingHints(renderHints);
    g2d.setColor(c.getForeground());
    //{{{ No rotation
    if (rotate == RotatedTextIcon.NONE) {
        g2d.drawGlyphVector(glyphs, x + 2, y + ascent);
    //}}}
    } else //{{{ Clockwise rotation
    if (rotate == RotatedTextIcon.CW) {
        AffineTransform trans = new AffineTransform();
        trans.concatenate(oldTransform);
        trans.translate(x, y + 2);
        trans.rotate(Math.PI / 2, height / 2, width / 2);
        g2d.setTransform(trans);
        g2d.drawGlyphVector(glyphs, (height - width) / 2, (width - height) / 2 + ascent);
    //}}}
    } else //{{{ Counterclockwise rotation
    if (rotate == RotatedTextIcon.CCW) {
        AffineTransform trans = new AffineTransform();
        trans.concatenate(oldTransform);
        trans.translate(x, y - 2);
        trans.rotate(Math.PI * 3 / 2, height / 2, width / 2);
        g2d.setTransform(trans);
        g2d.drawGlyphVector(glyphs, (height - width) / 2, (width - height) / 2 + ascent);
    //}}}
    }
    g2d.setTransform(oldTransform);
    g2d.setRenderingHints(oldHints);
//}}}
}