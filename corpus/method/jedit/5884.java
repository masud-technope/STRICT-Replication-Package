private double paintHeader(Graphics2D gfx, double pageX, double pageY, double pageWidth, boolean actuallyPaint) {
    String headerText = jEdit.getProperty("print.headerText", new String[] { buffer.getName() });
    FontRenderContext frc = gfx.getFontRenderContext();
    lm = font.getLineMetrics(headerText, frc);
    Rectangle2D bounds = font.getStringBounds(headerText, frc);
    Rectangle2D headerBounds = new Rectangle2D.Double(pageX, pageY, pageWidth, bounds.getHeight());
    if (actuallyPaint) {
        gfx.setColor(headerColor);
        gfx.fill(headerBounds);
        gfx.setColor(headerTextColor);
        gfx.drawString(headerText, (float) (pageX + (pageWidth - bounds.getWidth()) / 2), (float) (pageY + lm.getAscent()));
    }
    return headerBounds.getHeight();
}