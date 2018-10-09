public void finish() {
    addGlyphVectorOfLastRange();
    rangeFont = null;
    rangeStart += rangeLength;
    rangeLength = 0;
}