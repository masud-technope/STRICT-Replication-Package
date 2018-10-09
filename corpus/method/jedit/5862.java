/**
		 * @return current paper size
		 */
public Dimension getPaperSize() {
    // get the paper size set by the user
    PrintPreviewModel model = printPreviewPane.getModel();
    if (model != null) {
        PrintRequestAttributeSet attributes = model.getAttributes();
        float zoomLevel = model.getZoomLevel();
        Media media = (Media) attributes.get(Media.class);
        MediaSize mediaSize = null;
        if (media instanceof MediaSizeName) {
            MediaSizeName name = (MediaSizeName) media;
            mediaSize = MediaSize.getMediaSizeForName(name);
            int units = MediaPrintableArea.INCH;
            float dpi = 72 * zoomLevel;
            float paperWidth = mediaSize.getX(units) * dpi;
            float paperHeight = mediaSize.getY(units) * dpi;
            Dimension newSize = new Dimension();
            newSize.setSize(paperWidth, paperHeight);
            OrientationRequested orientationRequested = (OrientationRequested) attributes.get(OrientationRequested.class);
            if (OrientationRequested.LANDSCAPE.equals(orientationRequested) || OrientationRequested.REVERSE_LANDSCAPE.equals(orientationRequested)) {
                if (paperWidth < paperHeight) {
                    newSize.setSize(newSize.getHeight(), newSize.getWidth());
                }
            }
            return newSize;
        }
        // otherwise, use the default paper size
        Paper paper = model.getPaper();
        Dimension defaultSize = new Dimension(Double.valueOf(paper.getWidth() * zoomLevel).intValue(), Double.valueOf(paper.getHeight() * zoomLevel).intValue());
        return defaultSize;
    }
    return getSize();
}