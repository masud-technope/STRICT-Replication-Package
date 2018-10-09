private PrintService[] getPrintServices() {
    PrintService[] printServices = PrintServiceLookup.lookupPrintServices(DOC_FLAVOR, null);
    List<PrintService> services = new ArrayList<PrintService>(Arrays.asList(printServices));
    PrintService service = getPostscriptPrintService(null);
    if (service != null) {
        services.add(service);
    }
    printServices = services.toArray(new PrintService[0]);
    return printServices;
}