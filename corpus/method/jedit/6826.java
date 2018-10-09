// }}}
// {{{ extends TextAreaExtension
public void paintValidLine(Graphics2D gfx, int screenLine, int physicalLine, int start, int end, int y) {
    if (composedTextLayout != null) {
        int caret = owner.getCaretPosition();
        if (start <= caret && caret < end) {
            TextAreaPainter painter = owner.getPainter();
            // The hight and baseline are taken from
            // painter's FontMetrics instead of TextLayout
            // so that the composed text is rendered at
            // the same position with text in the TextArea.
            FontMetrics fm = painter.getFontMetrics();
            int x = owner.offsetToXY(caret).x;
            int width = Math.round(composedTextLayout.getAdvance());
            int height = painter.getLineHeight();
            int offset_to_baseline = height - (fm.getLeading() + 1) - fm.getDescent();
            int caret_x = x + composedCaretX;
            gfx.setColor(painter.getBackground());
            gfx.fillRect(x, y, width, height);
            gfx.setColor(painter.getForeground());
            composedTextLayout.draw(gfx, x, y + offset_to_baseline);
            gfx.setColor(painter.getCaretColor());
            gfx.drawLine(caret_x, y, caret_x, y + height - 1);
        }
    }
}