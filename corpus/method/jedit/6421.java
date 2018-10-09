public  FontSubstitution(Font mainFont, FontRenderContext frc, char[] text, int start) {
    this.mainFont = mainFont;
    this.frc = frc;
    this.text = text;
    rangeStart = start;
    rangeFont = null;
    rangeLength = 0;
    glyphs = new ArrayList<GlyphVector>();
}