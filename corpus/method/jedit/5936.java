// recalculates the media printable area when the printer, paper size,
// margin, or orientation changes
// returns null on okay, error message otherwise
protected String recalculate() {
    if (!PrinterDialog.this.isShowing()) {
        return null;
    }
    // get the printable area for the selected paper size and orientation
    int units = getUnits();
    MediaPrintableArea supportedArea = getSupportedPrintableArea();
    // Log.log( Log.DEBUG, this, "supportedArea = " + supportedArea.getX( units ) + ", " + supportedArea.getY( units ) + ", " + supportedArea.getWidth( units ) + ", " + supportedArea.getHeight( units ) );
    // get the selected paper size
    Media media = paperSizes.get(paperSize.getSelectedIndex());
    // get paper width and height
    MediaSize mediaSize = null;
    if (media instanceof MediaSizeName) {
        MediaSizeName name = (MediaSizeName) media;
        mediaSize = MediaSize.getMediaSizeForName(name);
    }
    float paperWidth = mediaSize.getX(units);
    float paperHeight = mediaSize.getY(units);
    // get the user desired margins
    float topMargin = topMarginField.getValue().floatValue();
    float leftMargin = leftMarginField.getValue().floatValue();
    float rightMargin = rightMarginField.getValue().floatValue();
    float bottomMargin = bottomMarginField.getValue().floatValue();
    // get the selected orientation and adjust the margins and width/height
    OrientationRequested orientationRequested = (OrientationRequested) orientation.getSelectedItem();
    rotateMargins(topMargin, leftMargin, rightMargin, bottomMargin, orientationRequested);
    // calculate new printable area
    float x = leftMargin;
    float y = topMargin;
    float width = paperWidth - leftMargin - rightMargin;
    float height = paperHeight - topMargin - bottomMargin;
    // check that the new printable area fits inside the supported area
    if (x < supportedArea.getX(units)) {
        return jEdit.getProperty("print.dialog.error.Invalid_left_margin", "Invalid left margin.");
    }
    if (y < supportedArea.getY(units)) {
        return jEdit.getProperty("print.dialog.error.Invalid_top_margin", "Invalid top margin.");
    }
    if (width <= 0 || x + width > supportedArea.getX(units) + supportedArea.getWidth(units)) {
        return jEdit.getProperty("print.dialog.error.Invalid_left_andor_right_margin.", "Invalid left and/or right margin.");
    }
    if (height <= 0 || y + height > supportedArea.getY(units) + supportedArea.getHeight(units)) {
        return jEdit.getProperty("print.dialog.error.Invalid_top_andor_bottom_margin", "Invalid top and/or bottom margin.");
    }
    // Log.log( Log.DEBUG, this, "new printable area: " + x + ", " + y + ", " + width + ", " + height );
    MediaPrintableArea area = new MediaPrintableArea(x, y, width, height, units);
    attributes.add(area);
    return null;
}