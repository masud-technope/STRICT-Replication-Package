/**
 * @deprecated
 * Replaced by BufferPrinter1_7. All the workarounds for java 1.3 and 1.4 don't
 * matter any more since jEdit requires java 1.8 at minimum.
 */
//{{{ getPrintJob() method
private static PrinterJob getPrintJob(String jobName) {
    job = PrinterJob.getPrinterJob();
    format = new HashPrintRequestAttributeSet();
    String settings = jEdit.getSettingsDirectory();
    if (settings != null) {
        String printSpecPath = MiscUtilities.constructPath(settings, "printspec");
        File filePrintSpec = new File(printSpecPath);
        if (filePrintSpec.exists()) {
            FileInputStream fileIn;
            ObjectInputStream obIn = null;
            try {
                fileIn = new FileInputStream(filePrintSpec);
                obIn = new ObjectInputStream(fileIn);
                format = (HashPrintRequestAttributeSet) obIn.readObject();
            } catch (Exception e) {
                Log.log(Log.ERROR, BufferPrinter1_4.class, e);
            } finally {
                try {
                    if (obIn != null)
                        obIn.close();
                } catch (IOException e) {
                }
            }
            //for backwards compatibility, the color variable is stored also as a property
            if (jEdit.getBooleanProperty("print.color"))
                format.add(Chromaticity.COLOR);
            else
                format.add(Chromaticity.MONOCHROME);
            //no need to always keep the same job name for every printout.
            format.add(new JobName(jobName, null));
        }
    }
    return job;
}