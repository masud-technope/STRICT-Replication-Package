private void drain() {
    if (skipDrain)
        return;
    if (bufImage == null) {
        //pre-computing all data that can be known at this time
        Dimension d = getSize();
        bufImage = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
        g = bufImage.createGraphics();
        rectangle = new Rectangle2D.Float(0, iTopPadding, d.width, d.height - iBottomPadding - iTopPadding);
        //"+1" makes sure every new line from below comes up smoothly
        //cause it gets pre-painted and clipped as needed
        iPipeLineCount = 1 + (int) Math.ceil(rectangle.height / iLineHeight);
        y = d.height + iBottomPadding;
        g.setFont(defaultFont);
        gradientPaint = new GradientPaint(rectangle.width / 2, iTopPadding + 80, new Color(80, 80, 80), rectangle.width / 2, iTopPadding, new Color(205, 205, 205));
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
    g.drawImage(image.getImage(), 0, 0, w, h, this);
    g.setFont(bottomLineFont);
    g.setPaint(new Color(55, 55, 55));
    g.drawString(sBottomLine, iBottomLineXOffset, iBottomLineYOffset);
    // Draw a highlight effect
    g.setPaint(new Color(255, 255, 255, 50));
    g.drawString(sBottomLine, iBottomLineXOffset + 1, iBottomLineYOffset + 1);
    g.setFont(defaultFont);
    g.setPaint(Color.black);
    g.drawRect(0, 0, w - 1, h - 1);
    g.clip(rectangle);
    g.setPaint(gradientPaint);
    int iDrawnLinesCount = 0, yCoor = 0;
    for (int i = 0; i < iLineCount; i++) {
        //check whether the text line is above the canvas, if so, the code skips it
        yCoor = y + i * iLineHeight;
        if (yCoor < iTopPadding) {
            continue;
        }
        //good to go, now draw only iPipeLineCount lines and get out from loop
        String sLine = vLines.get(i);
        int x = (w - fm.stringWidth(sLine)) / 2;
        g.drawString(sLine, x, yCoor);
        if (++iDrawnLinesCount >= iPipeLineCount) {
            break;
        }
    }
    y--;
    paint(getGraphics());
    //if so rewind
    if ((y + iListHeight) < iTopPadding) {
        y = h + iBottomPadding;
    }
}