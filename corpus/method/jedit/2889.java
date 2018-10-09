public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
    if (!isDataFlavorSupported(flavor))
        throw new UnsupportedFlavorException(flavor);
    Transferable transferable = flavors.get(flavor);
    return transferable.getTransferData(flavor);
}