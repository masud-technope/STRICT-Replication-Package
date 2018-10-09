//}}}
//{{{ updateMaxHorizontalScrollWidth() method
void updateMaxHorizontalScrollWidth() {
    maxHorizontalScrollWidth = chunkCache.getMaxHorizontalScrollWidth();
    horizontal.setValues(Math.max(0, Math.min(maxHorizontalScrollWidth + charWidth - painter.getWidth(), -horizontalOffset)), painter.getWidth(), 0, maxHorizontalScrollWidth + charWidth);
    horizontal.setUnitIncrement(10);
    horizontal.setBlockIncrement(painter.getWidth());
}