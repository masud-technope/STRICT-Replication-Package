//}}}
//{{{ getPageFormat() method
public static PageFormat getPageFormat() {
    //convert from PrintRequestAttributeSet to the pageFormat
    PrinterJob prnJob = getPrintJob(" ");
    PageFormat pf = prnJob.defaultPage();
    Paper pap = pf.getPaper();
    MediaSizeName media = (MediaSizeName) format.get(Media.class);
    MediaSize ms = MediaSize.getMediaSizeForName(media);
    MediaPrintableArea mediaarea = (MediaPrintableArea) format.get(MediaPrintableArea.class);
    if (mediaarea != null)
        pap.setImageableArea((mediaarea.getX(MediaPrintableArea.INCH) * 72), (mediaarea.getY(MediaPrintableArea.INCH) * 72), (mediaarea.getWidth(MediaPrintableArea.INCH) * 72), (mediaarea.getHeight(MediaPrintableArea.INCH) * 72));
    if (ms != null)
        pap.setSize((ms.getX(MediaSize.INCH) * 72), (ms.getY(MediaSize.INCH) * 72));
    pf.setPaper(pap);
    OrientationRequested orientation = (OrientationRequested) format.get(OrientationRequested.class);
    if (orientation != null) {
        if (orientation.getValue() == OrientationRequested.LANDSCAPE.getValue()) {
            pf.setOrientation(PageFormat.LANDSCAPE);
        } else if (orientation.getValue() == OrientationRequested.REVERSE_LANDSCAPE.getValue()) {
            pf.setOrientation(PageFormat.REVERSE_LANDSCAPE);
        } else if (orientation.getValue() == OrientationRequested.PORTRAIT.getValue()) {
            pf.setOrientation(PageFormat.PORTRAIT);
        } else if (orientation.getValue() == OrientationRequested.REVERSE_PORTRAIT.getValue()) {
            //doesnt exist??
            //pf.setOrientation(PageFormat.REVERSE_PORTRAIT);
            //then just do the next best thing
            pf.setOrientation(PageFormat.PORTRAIT);
        }
    }
    return pf;
}