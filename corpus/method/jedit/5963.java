private StreamPrintService getPostscriptPrintService(File outfile) {
    if (outfile == null) {
        outfile = new File(System.getProperty("user.home"), "out.ps");
    }
    String mimetype = "application/postscript";
    StreamPrintServiceFactory[] factories = StreamPrintServiceFactory.lookupStreamPrintServiceFactories(DOC_FLAVOR, mimetype);
    FileOutputStream fos;
    StreamPrintService printService = null;
    if (factories.length > 0) {
        try {
            fos = new FileOutputStream(outfile);
            printService = factories[0].getPrintService(fos);
        } catch (Exception e) {
            return null;
        }
    }
    return printService;
}