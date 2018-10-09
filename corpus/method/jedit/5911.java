@Override
public void printJobCompleted(PrintJobEvent pje) {
    // if the print service is a "print to file" service, then need to
    // flush and close the output stream.
    PrintService printService = pje.getPrintJob().getPrintService();
    if (printService instanceof StreamPrintService) {
        StreamPrintService streamService = (StreamPrintService) printService;
        OutputStream outputStream = streamService.getOutputStream();
        try {
            outputStream.flush();
        } catch (Exception // NOPMD
        e) {
        }
        try {
            outputStream.close();
        } catch (Exception // NOPMD
        e) {
        }
    }
    view.getStatus().setMessageAndClear("Printing complete.");
}