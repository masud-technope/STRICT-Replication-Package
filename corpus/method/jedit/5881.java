 BufferPrintable1_7(PrintRequestAttributeSet attributes, View view, Buffer buffer) {
    this.attributes = attributes;
    this.view = view;
    this.buffer = buffer;
    // pages and page ranges are calculated only once
    firstCall = true;
    reverse = attributes.containsKey(Reverse.class);
    if (attributes.containsKey(PrintRangeType.class)) {
        printRangeType = (PrintRangeType) attributes.get(PrintRangeType.class);
    }
    // the buffer might have a buffer property for the line numbers, if so, then
    // the buffer is a temporary buffer representing selected text and the line
    // numbers correspond with the selected lines.
    printingLineNumbers = (int[]) buffer.getProperty("printingLineNumbers");
    header = jEdit.getBooleanProperty("print.header");
    footer = jEdit.getBooleanProperty("print.footer");
    lineNumbers = jEdit.getBooleanProperty("print.lineNumbers");
    font = jEdit.getFontProperty("print.font");
    boolean color = Chromaticity.COLOR.equals(attributes.get(Chromaticity.class));
    //Log.log(Log.DEBUG, this, "color is " + color);
    //Log.log(Log.DEBUG, this, "chromaticity is " + attributes.get(Chromaticity.class));
    styles = org.gjt.sp.util.SyntaxUtilities.loadStyles(jEdit.getProperty("print.font"), jEdit.getIntegerProperty("print.fontsize", 10), color);
    styles[Token.NULL] = new SyntaxStyle(textColor, null, font);
    // assume the paper is white, so change any white text to black
    for (int i = 0; i < styles.length; i++) {
        SyntaxStyle s = styles[i];
        if (s.getForegroundColor().equals(Color.WHITE) && s.getBackgroundColor() == null) {
            styles[i] = new SyntaxStyle(Color.BLACK, s.getBackgroundColor(), s.getFont());
        }
    }
    lineList = new ArrayList<Chunk>();
    tokenHandler = new DisplayTokenHandler();
}