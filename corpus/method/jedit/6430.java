private void addGlyphVectorOfLastRange() {
    if (rangeLength == 0) {
        return;
    }
    Font font = (rangeFont == null) ? mainFont : rangeFont;
    GlyphVector gv = layoutGlyphVector(font, frc, text, rangeStart, rangeStart + rangeLength);
    glyphs.add(gv);
}