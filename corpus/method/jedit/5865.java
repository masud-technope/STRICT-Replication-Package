private void updateModel() {
    PrintPreviewModel pageFormat = printPreviewPane.getModel();
    if (pageFormat == null) {
        return;
    }
    // get the printable area from the attributes
    PrintRequestAttributeSet attributes = pageFormat.getAttributes();
    float zoomLevel = pageFormat.getZoomLevel();
    MediaPrintableArea mpa = (MediaPrintableArea) attributes.get(MediaPrintableArea.class);
    int units = MediaPrintableArea.INCH;
    // Paper uses 72 dpi
    double dpi = 72.0 * zoomLevel;
    double x = (double) mpa.getX(units) * dpi;
    double y = (double) mpa.getY(units) * dpi;
    double w = (double) mpa.getWidth(units) * dpi;
    double h = (double) mpa.getHeight(units) * dpi;
    // apply the mpa dimensions to the paper and page format
    Paper paper = new Paper();
    Dimension paperSize = getPaperSize();
    paper.setSize(paperSize.getWidth(), paperSize.getHeight());
    int orientation = PageFormat.PORTRAIT;
    OrientationRequested or = (OrientationRequested) attributes.get(OrientationRequested.class);
    if (OrientationRequested.LANDSCAPE.equals(or)) {
        paper.setSize(paperSize.getHeight(), paperSize.getWidth());
        orientation = PageFormat.LANDSCAPE;
    } else if (OrientationRequested.REVERSE_LANDSCAPE.equals(or)) {
        paper.setSize(paperSize.getHeight(), paperSize.getWidth());
        orientation = PageFormat.REVERSE_LANDSCAPE;
    }
    paper.setImageableArea(x, y, w, h);
    pageFormat.setPaper(paper);
    pageFormat.setOrientation(orientation);
}