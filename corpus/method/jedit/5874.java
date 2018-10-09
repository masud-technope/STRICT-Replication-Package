//}}}
//{{{ printPage() method
private void printPage(Graphics _gfx, PageFormat pageFormat, int pageIndex, boolean actuallyPaint) {
    //Log.log(Log.DEBUG,this,"printPage(" + pageIndex + ',' + actuallyPaint + ')');
    Graphics2D gfx = (Graphics2D) _gfx;
    gfx.setFont(font);
    double pageX = pageFormat.getImageableX();
    double pageY = pageFormat.getImageableY();
    double pageWidth = pageFormat.getImageableWidth();
    double pageHeight = pageFormat.getImageableHeight();
    if (header) {
        double headerHeight = paintHeader(gfx, pageX, pageY, pageWidth, actuallyPaint);
        pageY += headerHeight;
        pageHeight -= headerHeight;
    }
    if (footer) {
        double footerHeight = paintFooter(gfx, pageX, pageY, pageWidth, pageHeight, pageIndex, actuallyPaint);
        pageHeight -= footerHeight;
    }
    boolean glyphVector = jEdit.getBooleanProperty("print.glyphVector");
    double lineNumberWidth;
    //{{{ determine line number width
    if (lineNumbers) {
        // the +1's ensure that 99 gets 3 digits, 103 gets 4 digits,
        // and so on.
        int lineNumberDigits = (int) Math.ceil(Math.log(buffer.getLineCount() + 1) / Math.log(10)) + 1;
        // now that we know how many chars there are, get the width.
        char[] chars = new char[lineNumberDigits];
        for (int i = 0; i < chars.length; i++) chars[i] = ' ';
        lineNumberWidth = font.getStringBounds(chars, 0, lineNumberDigits, frc).getWidth();
    } else
        lineNumberWidth = 0.0;
    //}}}
    //Log.log(Log.DEBUG,this,"#2 - Page dimensions: "
    //	+ (pageWidth - lineNumberWidth)
    //	+ 'x' + pageHeight);
    //{{{ calculate tab size
    int tabSize = jEdit.getIntegerProperty("print.tabSize", 8);
    char[] chars = new char[tabSize];
    for (int i = 0; i < chars.length; i++) chars[i] = ' ';
    double tabWidth = font.getStringBounds(chars, 0, tabSize, frc).getWidth();
    PrintTabExpander e = new PrintTabExpander(tabWidth);
    //}}}
    lm = font.getLineMetrics("gGyYX", frc);
    //Log.log(Log.DEBUG,this,"Line height is " + lm.getHeight());
    double y = 0.0;
    print_loop: for (; ; ) {
        if (currentPhysicalLine == buffer.getLineCount()) {
            Log.log(Log.DEBUG, this, "Finished buffer");
            end = true;
            break print_loop;
        }
        if (!jEdit.getBooleanProperty("print.folds", true) && !view.getTextArea().getDisplayManager().isLineVisible(currentPhysicalLine)) {
            Log.log(Log.DEBUG, this, "Skipping invisible line");
            currentPhysicalLine++;
            continue;
        }
        lineList.clear();
        tokenHandler.init(styles, frc, e, lineList, (float) (pageWidth - lineNumberWidth), -1);
        buffer.markTokens(currentPhysicalLine, tokenHandler);
        if (lineList.isEmpty())
            lineList.add(null);
        if (y + (lm.getHeight() * lineList.size()) >= pageHeight) {
            Log.log(Log.DEBUG, this, "Finished page before line " + currentPhysicalLine);
            break print_loop;
        }
        if (lineNumbers && actuallyPaint) {
            gfx.setFont(font);
            gfx.setColor(lineNumberColor);
            gfx.drawString(String.valueOf(currentPhysicalLine + 1), (float) pageX, (float) (pageY + y + lm.getHeight()));
        }
        for (Chunk chunk : lineList) {
            y += lm.getHeight();
            Chunk chunks = chunk;
            if (chunks != null && actuallyPaint) {
                FontMetrics metrics = gfx.getFontMetrics();
                Chunk.paintChunkBackgrounds(chunks, gfx, (float) (pageX + lineNumberWidth), (float) (pageY + y), metrics.getHeight());
                Chunk.paintChunkList(chunks, gfx, (float) (pageX + lineNumberWidth), (float) (pageY + y), glyphVector);
            }
        }
        currentPhysicalLine++;
    }
}