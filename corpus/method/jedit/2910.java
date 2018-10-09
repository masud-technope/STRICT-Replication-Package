public Transferable getTransferable(TextArea textArea, String text) {
    Map<DataFlavor, Transferable> flavors = new HashMap<DataFlavor, Transferable>();
    for (JEditTransferableService service : services) {
        if (service.accept(textArea, text)) {
            Transferable t = service.getTransferable(textArea, text);
            DataFlavor[] supportedDataFlavor = t.getTransferDataFlavors();
            for (DataFlavor dataFlavor : supportedDataFlavor) {
                flavors.put(dataFlavor, t);
            }
        }
    }
    Transferable transferable = new JEditTransferable(flavors);
    return transferable;
}