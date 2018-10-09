// the default margins are the margins that allow the maximum supported
// printable area by the currently selected printer, paper, and orientation,
// returns float[]{topMargin, leftMargin, rightMargin, bottomMargin}
private float[] getMinimumMargins() {
    // get the printable area for the selected paper size and orientation
    int units = getUnits();
    boolean integerOnly = units == MediaPrintableArea.MM;
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
    // calculate the default margins
    float topMargin = supportedArea.getY(units);
    topMargin = integerOnly ? Double.valueOf(Math.ceil(topMargin)).floatValue() : topMargin;
    float leftMargin = supportedArea.getX(units);
    leftMargin = integerOnly ? Double.valueOf(Math.ceil(leftMargin)).floatValue() : leftMargin;
    float rightMargin = Math.max(0.0f, paperWidth - leftMargin - supportedArea.getWidth(units));
    rightMargin = integerOnly ? Double.valueOf(Math.ceil(rightMargin)).floatValue() : rightMargin;
    float bottomMargin = Math.max(0.0f, paperHeight - topMargin - supportedArea.getHeight(units));
    bottomMargin = integerOnly ? Double.valueOf(Math.ceil(bottomMargin)).floatValue() : bottomMargin;
    // adjust the margins for the paper orientation
    OrientationRequested orientationRequested = (OrientationRequested) orientation.getSelectedItem();
    rotateMargins(topMargin, leftMargin, rightMargin, bottomMargin, orientationRequested);
    //Log.log( Log.DEBUG, this, "getMinimumMargins returning " + topMargin + ", " + leftMargin + ", " + rightMargin + ", " + bottomMargin);
    return new float[] { topMargin, leftMargin, rightMargin, bottomMargin };
}