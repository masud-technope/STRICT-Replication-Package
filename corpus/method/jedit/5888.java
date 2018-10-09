private double paintFooter(Graphics2D gfx, double pageX, double pageY, double pageWidth, double pageHeight, int pageIndex, boolean actuallyPaint) {
    String footerText = jEdit.getProperty("print.footerText", new Object[] { new Date(), Integer.valueOf(pageIndex) });
    FontRenderContext frc = gfx.getFontRenderContext();
    lm = font.getLineMetrics(footerText, frc);
    Rectangle2D bounds = font.getStringBounds(footerText, frc);
    Rectangle2D footerBounds = new Rectangle2D.Double(pageX, pageY + pageHeight - bounds.getHeight(), pageWidth, bounds.getHeight());
    if (actuallyPaint) {
        gfx.setColor(footerColor);
        gfx.fill(footerBounds);
        gfx.setColor(footerTextColor);
        gfx.drawString(footerText, (float) (pageX + (pageWidth - bounds.getWidth()) / 2), (float) (pageY + pageHeight - bounds.getHeight() + lm.getAscent()));
    }
    return footerBounds.getHeight();
}