// have the printable calculate the pages and ranges, the map has the page
// number as the key, a range containing the start and end line numbers of
// that page
private static HashMap<Integer, Range> getPageRanges(BufferPrintable1_7 printable, PrintRequestAttributeSet attributes) {
    PageFormat pageFormat = createPageFormat(attributes);
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    BufferedImage image = new BufferedImage(Double.valueOf(pageFormat.getImageableWidth()).intValue(), Double.valueOf(pageFormat.getImageableHeight()).intValue(), BufferedImage.TYPE_INT_RGB);
    Graphics graphics = ge.createGraphics(image);
    Paper paper = pageFormat.getPaper();
    Rectangle2D.Double clipRegion = new Rectangle2D.Double(paper.getImageableX(), paper.getImageableY(), paper.getImageableWidth(), paper.getImageableHeight());
    graphics.setClip(clipRegion);
    try {
        // calculate which lines belong to each page
        HashMap<Integer, Range> pageLineRanges = printable.calculatePages(graphics, pageFormat);
        PageRanges pr = (PageRanges) attributes.get(PageRanges.class);
        if (pr == null) {
            pr = new PageRanges(1, 1000);
        }
        // then keep only the pages the user has selected
        HashMap<Integer, Range> newLineRanges = new HashMap<Integer, Range>();
        for (Integer i : pageLineRanges.keySet()) {
            if (pr.contains(i)) {
                newLineRanges.put(i, pageLineRanges.get(i));
            }
        }
        return newLineRanges;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}