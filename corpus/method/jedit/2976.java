//{{{ getToolTipText() method
@Override
public String getToolTipText(int x, int y) {
    if (isMarkerHighlightEnabled()) {
        int lineHeight = textArea.getPainter().getLineHeight();
        if (lineHeight == 0)
            return null;
        int line = y / lineHeight;
        int start = textArea.getScreenLineStartOffset(line);
        int end = textArea.getScreenLineEndOffset(line);
        if (start == -1 || end == -1)
            return null;
        Buffer buffer = (Buffer) textArea.getBuffer();
        Marker marker = buffer.getMarkerInRange(start, end);
        if (marker != null) {
            char shortcut = marker.getShortcut();
            if (shortcut == '\0')
                return jEdit.getProperty("view.gutter.marker.no-name");
            else {
                String[] args = { String.valueOf(shortcut) };
                return jEdit.getProperty("view.gutter.marker", args);
            }
        }
    }
    return null;
//}}}
}