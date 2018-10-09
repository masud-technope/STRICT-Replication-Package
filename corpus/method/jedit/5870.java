//{{{ BufferPrintable constructor
 BufferPrintable(PrinterJob job, Object format, View view, Buffer buffer, Font font, boolean header, boolean footer, boolean lineNumbers, boolean color) {
    this.job = job;
    this.format = format;
    this.view = view;
    this.buffer = buffer;
    this.font = font;
    this.header = header;
    this.footer = footer;
    this.lineNumbers = lineNumbers;
    styles = org.gjt.sp.util.SyntaxUtilities.loadStyles(jEdit.getProperty("print.font"), jEdit.getIntegerProperty("print.fontsize", 10), color);
    styles[Token.NULL] = new SyntaxStyle(textColor, null, font);
    // Change any white text to black
    for (int i = 0; i < styles.length; i++) {
        SyntaxStyle s = styles[i];
        if (s.getForegroundColor().equals(Color.WHITE) && s.getBackgroundColor() == null) {
            styles[i] = new SyntaxStyle(Color.BLACK, styles[i].getBackgroundColor(), styles[i].getFont());
        }
    }
    lineList = new ArrayList<Chunk>();
    tokenHandler = new DisplayTokenHandler();
}