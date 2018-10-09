//{{{ paintScreenLineRange() method
private void paintScreenLineRange(Graphics2D gfx, int firstLine, int lastLine, int[] physicalLines, int[] start, int[] end, int y, int lineHeight) {
    Iterator<Entry> iter = extensions.iterator();
    while (iter.hasNext()) {
        TextAreaExtension ext = iter.next().ext;
        try {
            ext.paintScreenLineRange(gfx, firstLine, lastLine, physicalLines, start, end, y, lineHeight);
        } catch (Throwable t) {
            Log.log(Log.ERROR, this, t);
            iter.remove();
        }
    }
}