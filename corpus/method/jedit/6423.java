private void addRange(Font font, int length) {
    assert length >= 0;
    if (length == 0) {
        return;
    }
    if (font == rangeFont) {
        rangeLength += length;
    } else {
        addGlyphVectorOfLastRange();
        rangeFont = font;
        rangeStart += rangeLength;
        rangeLength = length;
    }
}