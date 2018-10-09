//}}}
//{{{ print() method
public static void print(final View view, final Buffer buffer, boolean selection) {
    job = getPrintJob(MiscUtilities.abbreviateView(buffer.getPath()));
    boolean header = jEdit.getBooleanProperty("print.header");
    boolean footer = jEdit.getBooleanProperty("print.footer");
    boolean lineNumbers = jEdit.getBooleanProperty("print.lineNumbers");
    boolean color = jEdit.getBooleanProperty("print.color");
    Font font = jEdit.getFontProperty("print.font");
    BufferPrintable printable = new BufferPrintable(job, format, view, buffer, font, header, footer, lineNumbers, color);
    job.setPrintable(printable);
    if (!job.printDialog(format))
        return;
    savePrintSpec();
    printable.print();
}