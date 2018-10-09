/**
 	 * Parses the file to determine what lines belong to which page.
 	 * @param _gfx The graphics context to use for the calculations.
 	 * @param pageFormat The page format to use for the calculations.
 	 * @param force If true, force the calculation regardless of large file and long
 	 * line limits.
 	 * @return A hashmap of page number = line range for that page
 	 *
 	 * NOTE: This handles large files and long lines poorly, if the buffer size
 	 * is larger than the "largeBufferSize" property, a printer exception is thrown.
 	 * Same for long lines, if any line in the buffer is longer than the 
 	 * "longLineLimit" property, a printer exception is thrown. This seems to be
 	 * an adequate way to handle the large files, but is probably a poor way to
 	 * handle files that aren't particularly large but only have one line.
 	 */
protected HashMap<Integer, Range> calculatePages(Graphics _gfx, PageFormat pageFormat) throws PrinterException {
    //Log.log(Log.DEBUG, this, "calculatePages for " + buffer.getName());
    //Log.log(Log.DEBUG, this, "graphics.getClip = " + _gfx.getClip());
    pages = new HashMap<Integer, Range>();
    // check large file settings
    String largeFileMode = buffer.getStringProperty("largefilemode");
    if (!"full".equals(largeFileMode)) {
        int largeBufferSize = jEdit.getIntegerProperty("largeBufferSize", 4000000);
        if (buffer.getLength() > largeBufferSize) {
            throw new PrinterException("Buffer is too large to print.");
        }
    }
    // ensure graphics and font rendering context are valid
    if (_gfx == null) {
        // this can happen on startup when the graphics is not yet valid
        return pages;
    }
    // use the rendering hints set in the text area option pane. The affine
    // transform is basic and seems to work well in all cases. I've found
    // that it's necessary to turn on the print spacing workaround in the
    // text area option pane to not get character overlap. I think this
    // setting should be on by default since it causes graphics.drawGlyphVector
    // to be used to draw the characters and the javadoc says, "This is the 
    // fastest way to render a set of characters to the screen."
    Graphics2D gfx = (Graphics2D) _gfx;
    gfx.setRenderingHint(KEY_TEXT_ANTIALIASING, view.getTextArea().getPainter().getAntiAlias().renderHint());
    boolean useFractionalFontMetrics = jEdit.getBooleanProperty("view.fracFontMetrics");
    gfx.setRenderingHint(KEY_FRACTIONALMETRICS, (useFractionalFontMetrics ? VALUE_FRACTIONALMETRICS_ON : VALUE_FRACTIONALMETRICS_OFF));
    gfx.setFont(font);
    gfx.setTransform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
    frc = gfx.getFontRenderContext();
    //Log.log(Log.DEBUG, this, "Font render context is " + frc);
    // maximum printable area
    double pageX = pageFormat.getImageableX();
    double pageY = pageFormat.getImageableY();
    double pageWidth = pageFormat.getImageableWidth();
    double pageHeight = pageFormat.getImageableHeight();
    // calculate header height
    if (header) {
        double headerHeight = paintHeader(gfx, pageX, pageY, pageWidth, false);
        pageY += headerHeight;
        pageHeight -= headerHeight;
    //Log.log(Log.DEBUG, this, "calculatePages, w/header imageable: x=" + pageX + ", y=" + pageY + ", w=" + pageWidth + ", h=" + pageHeight);
    }
    // calculate footer height
    if (footer) {
        double footerHeight = paintFooter(gfx, pageX, pageY, pageWidth, pageHeight, 0, false);
        pageHeight -= footerHeight;
    //Log.log(Log.DEBUG, this, "calculatePages, w/footer imageable: x=" + pageX + ", y=" + pageY + ", w=" + pageWidth + ", h=" + pageHeight);
    }
    double lineNumberWidth = 0.0;
    // determine line number width
    if (lineNumbers) {
        String lineNumberDigits = String.valueOf(buffer.getLineCount());
        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < lineNumberDigits.length(); i++) {
            digits.append('0');
        }
        lineNumberWidth = font.getStringBounds(digits.toString(), frc).getWidth();
    }
    // calculate tab size
    int tabSize = jEdit.getIntegerProperty("print.tabSize", 4);
    StringBuilder tabs = new StringBuilder();
    char[] chars = new char[tabSize];
    for (int i = 0; i < tabSize; i++) {
        tabs.append(' ');
    }
    double tabWidth = font.getStringBounds(tabs.toString(), frc).getWidth();
    PrintTabExpander tabExpander = new PrintTabExpander(tabWidth);
    // prep for calculations
    lm = font.getLineMetrics("gGyYX", frc);
    float lineHeight = lm.getHeight();
    boolean printFolds = jEdit.getBooleanProperty("print.folds", true);
    currentPhysicalLine = 0;
    int pageCount = 1;
    int startLine = 0;
    double y = 0.0;
    // measure each line
    int longLineLimit = jEdit.getIntegerProperty("longLineLimit", 4000);
    int bufferLineCount = buffer.getLineCount();
    while (currentPhysicalLine <= bufferLineCount) {
        // size page, roughly 80 characters wide and 50 lines tall.
        if (currentPhysicalLine < bufferLineCount && buffer.getLineLength(currentPhysicalLine) > longLineLimit) {
            throw new PrinterException("Line " + (currentPhysicalLine + 1) + " is too long to print.");
        }
        if (currentPhysicalLine == bufferLineCount) {
            // last page
            Range range = new Range(startLine, currentPhysicalLine);
            pages.put(Integer.valueOf(pageCount), range);
            //Log.log(Log.DEBUG, this, "calculatePages, page " + pageCount + " has " + range);
            break;
        }
        // skip folded lines
        if (!printFolds && !view.getTextArea().getDisplayManager().isLineVisible(currentPhysicalLine)) {
            ++currentPhysicalLine;
            continue;
        }
        // fill the line list
        lineList.clear();
        tokenHandler.init(styles, frc, tabExpander, lineList, (float) (pageWidth - lineNumberWidth), 0);
        buffer.markTokens(currentPhysicalLine, tokenHandler);
        // check that these lines will fit on the page
        if (y + (lineHeight * (lineList.isEmpty() ? 1 : lineList.size())) > pageHeight) {
            Range range = new Range(startLine, Math.max(0, currentPhysicalLine - 1));
            pages.put(Integer.valueOf(pageCount), range);
            //Log.log(Log.DEBUG, this, "calculatePages, page " + pageCount + " has " + range);
            ++pageCount;
            startLine = currentPhysicalLine;
            y = 0.0;
            continue;
        }
        for (int i = 0; i < (lineList.isEmpty() ? 1 : lineList.size()); i++) {
            y += lineHeight;
        }
        ++currentPhysicalLine;
    }
    return pages;
}