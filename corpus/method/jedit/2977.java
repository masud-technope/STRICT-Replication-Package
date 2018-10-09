//{{{ paintValidLine() method
@Override
public void paintValidLine(Graphics2D gfx, int screenLine, int physicalLine, int start, int end, int y) {
    if (isMarkerHighlightEnabled()) {
        Buffer buffer = (Buffer) textArea.getBuffer();
        if (buffer.getMarkerInRange(start, end) != null) {
            gfx.setColor(getMarkerHighlightColor());
            int height = textArea.getPainter().getLineHeight();
            gfx.fillRect(0, y, textArea.getGutter().getWidth(), height);
        }
    }
//}}}
}