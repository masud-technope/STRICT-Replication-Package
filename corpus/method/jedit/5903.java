/**
 	 * This is intended for use by the PrintPreview dialog.	
 	 */
protected static void printPage(PrintPreviewModel model) {
    String jobName = MiscUtilities.abbreviateView(model.getBuffer().getPath());
    PrintRequestAttributeSet attrs = model.getAttributes();
    attrs.add(new JobName(jobName, null));
    Reverse reverse = (Reverse) attrs.get(Reverse.class);
    if (reverse != null) {
        attrs.remove(Reverse.class);
    }
    // set up the print job
    PrintService printService = model.getPrintService();
    if (printService == null) {
        printService = PrintServiceLookup.lookupDefaultPrintService();
    }
    if (printService != null) {
        try {
            job = printService.createPrintJob();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(model.getView(), jEdit.getProperty("print-error.message", new String[] { e.getMessage() }), jEdit.getProperty("print-error.title"), JOptionPane.ERROR_MESSAGE);
            return;
        }
    } else {
        JOptionPane.showMessageDialog(model.getView(), jEdit.getProperty("print-error.message", new String[] { "Invalid print service." }), jEdit.getProperty("print-error.title"), JOptionPane.ERROR_MESSAGE);
        return;
    }
    // set up the printable to print just the requested pages
    Buffer buffer = model.getBuffer();
    PrintRangeType printRangeType = (PrintRangeType) attrs.get(PrintRangeType.class);
    if (PrintRangeType.SELECTION.equals(printRangeType)) {
        buffer = getSelectionBuffer(model.getView(), buffer);
    }
    BufferPrintable1_7 printable = new BufferPrintable1_7(attrs, model.getView(), buffer);
    printable.setPages(model.getPageRanges());
    int pageNumber = model.getPageNumber();
    try {
        printable.print(model.getGraphics(), model, pageNumber);
    } catch (Exception e) {
        e.printStackTrace();
    }
    if (reverse != null) {
        attrs.add(reverse);
    }
}