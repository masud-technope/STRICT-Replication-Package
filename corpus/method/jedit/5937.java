private MediaPrintableArea getSupportedPrintableArea() {
    MediaPrintableArea supportedArea = null;
    HashPrintRequestAttributeSet attrs = new HashPrintRequestAttributeSet();
    if (paperSizes != null) {
        attrs.add(paperSizes.get(paperSize.getSelectedIndex()));
    }
    if (orientation != null && orientation.getSelectedItem() != null) {
        attrs.add((OrientationRequested) orientation.getSelectedItem());
    }
    Object values = getPrintService().getSupportedAttributeValues(MediaPrintableArea.class, DocFlavor.SERVICE_FORMATTED.PRINTABLE, attrs);
    if (values != null) {
        MediaPrintableArea[] mpas = (MediaPrintableArea[]) values;
        supportedArea = mpas[0];
    } else {
        supportedArea = (MediaPrintableArea) getPrintService().getDefaultAttributeValue(MediaPrintableArea.class);
    }
    return supportedArea;
}