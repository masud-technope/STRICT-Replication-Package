//}}}
//{{{ pageSetup() method
public static void pageSetup(View view) {
    job = getPrintJob();
    PageFormat newFormat = job.pageDialog(format);
    if (newFormat != null) {
        format = newFormat;
        jEdit.setIntegerProperty("print.orientation", format.getOrientation());
        Paper paper = format.getPaper();
        jEdit.setDoubleProperty("print.width", paper.getImageableWidth());
        jEdit.setDoubleProperty("print.height", paper.getImageableHeight());
        jEdit.setDoubleProperty("print.x", paper.getImageableX());
        jEdit.setDoubleProperty("print.y", paper.getImageableY());
        jEdit.setDoubleProperty("print.pagewidth", paper.getWidth());
        jEdit.setDoubleProperty("print.pageheight", paper.getHeight());
    }
}