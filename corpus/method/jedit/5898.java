// create a page format using the values from the given attribute set
private static PageFormat createPageFormat(PrintRequestAttributeSet attributes) {
    Paper paper = new Paper();
    MediaPrintableArea mpa = (MediaPrintableArea) attributes.get(MediaPrintableArea.class);
    int units = MediaPrintableArea.INCH;
    // Paper uses 72 dpi
    double dpi = 72.0;
    double x = (double) mpa.getX(units) * dpi;
    double y = (double) mpa.getY(units) * dpi;
    double w = (double) mpa.getWidth(units) * dpi;
    double h = (double) mpa.getHeight(units) * dpi;
    paper.setImageableArea(x, y, w, h);
    int orientation = PageFormat.PORTRAIT;
    OrientationRequested or = (OrientationRequested) attributes.get(OrientationRequested.class);
    if (OrientationRequested.LANDSCAPE.equals(or) || OrientationRequested.REVERSE_LANDSCAPE.equals(or)) {
        orientation = PageFormat.LANDSCAPE;
    }
    PageFormat pageFormat = new PageFormat();
    pageFormat.setPaper(paper);
    pageFormat.setOrientation(orientation);
    return pageFormat;
}