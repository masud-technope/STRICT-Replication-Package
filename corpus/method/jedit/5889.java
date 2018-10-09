/**
 * @deprecated
 * Replaced by BufferPrinter1_7. All the workarounds for java 1.3 and 1.4 don't
 * matter any more since jEdit requires java 1.8 at minimum.
 */
//{{{ getPrintJob() method
private static PrinterJob getPrintJob() {
    job = PrinterJob.getPrinterJob();
    int orientation = jEdit.getIntegerProperty("print.orientation", PageFormat.PORTRAIT);
    double width = jEdit.getDoubleProperty("print.width", 0);
    double height = jEdit.getDoubleProperty("print.height", 0);
    double x = jEdit.getDoubleProperty("print.x", 0);
    double y = jEdit.getDoubleProperty("print.y", 0);
    double pagewidth = jEdit.getDoubleProperty("print.pagewidth", 0);
    double pageheight = jEdit.getDoubleProperty("print.pageheight", 0);
    format = job.defaultPage();
    //format.setOrientation(PageFormat.PORTRAIT);
    if (width != 0 && height != 0) {
        Paper pap = format.getPaper();
        pap.setImageableArea(x, y, width, height);
        pap.setSize(pagewidth, pageheight);
        format.setPaper(pap);
    }
    format.setOrientation(orientation);
    return job;
}