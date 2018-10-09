// print to a printer
public static void print(final View view, final Buffer buffer) {
    Log.log(Log.DEBUG, BufferPrinter1_7.class, "print buffer " + buffer.getPath());
    // load any saved printing attributes, these are put into 'format'
    loadPrintSpec();
    String jobName = MiscUtilities.abbreviateView(buffer.getPath());
    format.add(new JobName(jobName, null));
    // show the print dialog so the user can make their printer settings
    PrinterDialog printerDialog = new PrinterDialog(view, format, false);
    if (printerDialog.isCanceled()) {
        Log.log(Log.DEBUG, BufferPrinter1_7.class, "print dialog canceled");
        return;
    }
    // set up the print job
    PrintService printService = printerDialog.getPrintService();
    if (printService != null) {
        //Log.log(Log.DEBUG, BufferPrinter1_7.class, "using print service: " + printService);
        try {
            job = printService.createPrintJob();
            job.addPrintJobListener(new BufferPrinter1_7.JobListener(view));
            format = printerDialog.getAttributes();
            savePrintSpec();
            EditBus.send(new PropertiesChanged(null));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, jEdit.getProperty("print-error.message", new String[] { e.getMessage() }), jEdit.getProperty("print-error.title"), JOptionPane.ERROR_MESSAGE);
            return;
        }
    } else {
        JOptionPane.showMessageDialog(view, jEdit.getProperty("print-error.message", new String[] { "Invalid print service." }), jEdit.getProperty("print-error.title"), JOptionPane.ERROR_MESSAGE);
        return;
    }
    // check if printing a selection, if so, create a new temporary buffer
    // containing just the selection
    // TODO: I'm not taking even/odd page setting into account here, nor am
    // I considering any page values that may have been set in the page range.
    // I don't think this is important for printing a selection, which is
    // generally just a few lines rather than pages. I could be wrong...
    Buffer tempBuffer = buffer;
    PrintRangeType printRangeType = (PrintRangeType) format.get(PrintRangeType.class);
    if (PrintRangeType.SELECTION.equals(printRangeType)) {
        tempBuffer = getSelectionBuffer(view, buffer);
    }
    // copy the doc attributes from the print format attributes
    //Log.log(Log.DEBUG, BufferPrinter1_7.class, "--- print request attributes ---");
    DocAttributeSet docAttributes = new HashDocAttributeSet();
    Attribute[] attributes = format.toArray();
    for (Attribute attribute : attributes) {
        boolean isDocAttr = attribute instanceof DocAttribute;
        //Log.log(Log.DEBUG, BufferPrinter1_7.class, attribute.getName() + " = " + attribute + ", is doc attr? " + isDocAttr);
        if (isDocAttr) {
            docAttributes.add(attribute);
        }
    }
    //Log.log(Log.DEBUG, BufferPrinter1_7.class, "--- end print request attributes ---");
    // set up the printable
    BufferPrintable1_7 printable = new BufferPrintable1_7(format, view, tempBuffer);
    final Doc doc = new SimpleDoc(printable, DocFlavor.SERVICE_FORMATTED.PRINTABLE, docAttributes);
    // ready to print
    // run this in a background thread, it can take some time for a large buffer
    Runnable runner = new Runnable() {

        public void run() {
            try {
                //Log.log(Log.DEBUG, this, "sending print job to printer");
                job.print(doc, format);
            //Log.log(Log.DEBUG, this, "printing complete");
            } catch (PrintException e) {
                JOptionPane.showMessageDialog(view, jEdit.getProperty("print-error.message", new String[] { e.getMessage() }), jEdit.getProperty("print-error.title"), JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    ThreadUtilities.runInBackground(runner);
}