// actually print the page to the graphics context
// pageIndex is 1-based
private void printPage(Graphics _gfx, PageFormat pageFormat, int pageIndex, boolean actuallyPaint) {
    //Log.log(Log.DEBUG, this, "printPage(" + pageIndex + ", " + actuallyPaint + ')');
    Graphics2D gfx = (Graphics2D) _gfx;
    float zoomLevel = 1.0f;
    if (pageFormat instanceof PrintPreviewModel) {
        PrintPreviewModel model = (PrintPreviewModel) pageFormat;
        zoomLevel = model.getZoomLevel();
        font = font.deriveFont(font.getSize() * zoomLevel);
        gfx.setRenderingHint(KEY_TEXT_ANTIALIASING, view.getTextArea().getPainter().getAntiAlias().renderHint());
        boolean useFractionalFontMetrics = jEdit.getBooleanProperty("view.fracFontMetrics");
        gfx.setRenderingHint(KEY_FRACTIONALMETRICS, (useFractionalFontMetrics ? VALUE_FRACTIONALMETRICS_ON : VALUE_FRACTIONALMETRICS_OFF));
        for (int i = 0; i < styles.length; i++) {
            SyntaxStyle s = styles[i];
            styles[i] = new SyntaxStyle(s.getForegroundColor(), s.getBackgroundColor(), font);
        }
    }
    gfx.setFont(font);
    if (frc == null) {
        frc = gfx.getFontRenderContext();
    }
    // printable dimensions
    double pageX = pageFormat.getImageableX();
    double pageY = pageFormat.getImageableY();
    double pageWidth = pageFormat.getImageableWidth();
    double pageHeight = pageFormat.getImageableHeight();
    // print header
    if (header) {
        double headerHeight = paintHeader(gfx, pageX, pageY, pageWidth, actuallyPaint);
        pageY += headerHeight;
        pageHeight -= headerHeight;
    }
    // print footer
    if (footer) {
        double footerHeight = paintFooter(gfx, pageX, pageY, pageWidth, pageHeight, pageIndex, actuallyPaint);
        pageHeight -= footerHeight;
    }
    // determine line number width
    double lineNumberWidth = 0.0;
    if (lineNumbers) {
        String lineNumberDigits = String.valueOf(buffer.getLineCount());
        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < lineNumberDigits.length(); i++) {
            digits.append('0');
        }
        lineNumberWidth = font.getStringBounds(digits.toString(), frc).getWidth();
    }
    //Log.log(Log.DEBUG,this,"#2 - Page dimensions: " + (pageWidth - lineNumberWidth) + 'x' + pageHeight);
    // calculate tab size
    int tabSize = jEdit.getIntegerProperty("print.tabSize", 4);
    StringBuilder tabs = new StringBuilder();
    for (int i = 0; i < tabSize; i++) {
        tabs.append(' ');
    }
    double tabWidth = font.getStringBounds(tabs.toString(), frc).getWidth();
    PrintTabExpander tabExpander = new PrintTabExpander(tabWidth);
    // prep for printing lines
    lm = font.getLineMetrics("gGyYX", frc);
    float lineHeight = lm.getHeight();
    //Log.log(Log.DEBUG, this, "Line height is " + lineHeight);
    double y = 0.0;
    Range range = pages.get(pageIndex);
    //Log.log(Log.DEBUG, this, "printing range for page " + pageIndex + ": " + range);
    int start = printingLineNumbers == null ? range.getStart() : 0;
    int end = printingLineNumbers == null ? range.getEnd() : printingLineNumbers.length - 1;
    // print each line
    for (currentPhysicalLine = start; currentPhysicalLine <= end; currentPhysicalLine++) {
        if (currentPhysicalLine == buffer.getLineCount()) {
            //Log.log(Log.DEBUG, this, "The end");
            break;
        }
        if (!jEdit.getBooleanProperty("print.folds", true) && !view.getTextArea().getDisplayManager().isLineVisible(currentPhysicalLine)) {
            //Log.log(Log.DEBUG, this, "Skipping invisible line");
            continue;
        }
        // fill the line list
        lineList.clear();
        tokenHandler.init(styles, frc, tabExpander, lineList, (float) (pageWidth - lineNumberWidth), -1);
        buffer.markTokens(currentPhysicalLine, tokenHandler);
        if (lineNumbers && actuallyPaint) {
            gfx.setFont(font);
            gfx.setColor(lineNumberColor);
            int lineNo = currentPhysicalLine + 1;
            if (printingLineNumbers != null && currentPhysicalLine < printingLineNumbers.length) {
                lineNo = printingLineNumbers[currentPhysicalLine] + 1;
            }
            gfx.drawString(String.valueOf(lineNo), (float) pageX, (float) (pageY + y + lineHeight));
        }
        if (lineList.isEmpty()) {
            // handle blank line
            y += lineHeight;
        } else {
            for (Chunk chunk : lineList) {
                y += lineHeight;
                Chunk chunks = chunk;
                if (chunks != null && actuallyPaint) {
                    Chunk.paintChunkBackgrounds(chunks, gfx, (float) (pageX + lineNumberWidth), (float) (pageY + y), lineHeight);
                    Chunk.paintChunkList(chunks, gfx, (float) (pageX + lineNumberWidth), (float) (pageY + y), true);
                }
            }
        }
        if (currentPhysicalLine == end) {
            //Log.log(Log.DEBUG,this,"Finished page");
            break;
        }
    }
}