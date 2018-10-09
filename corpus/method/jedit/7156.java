//}}}
//{{{ setMaxLineLength() method
private void setMaxLineLength(int maxLineLen) {
    this.maxLineLen = maxLineLen;
    if (maxLineLen <= 0) {
        if (softWrap) {
            wrapToWidth = true;
            wrapMargin = painter.getWidth() - charWidth * 3;
        } else {
            wrapToWidth = false;
            wrapMargin = 0;
        }
    } else {
        int estimate = (int) Math.ceil(charWidthDouble * maxLineLen);
        if (softWrap && painter.getWidth() < estimate) {
            wrapToWidth = true;
            wrapMargin = painter.getWidth() - charWidth * 3;
        } else {
            wrapToWidth = false;
            wrapMargin = estimate;
        }
    }
}