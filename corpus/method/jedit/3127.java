@Override
public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
    if (!isDataFlavorSupported(flavor))
        throw new UnsupportedFlavorException(flavor);
    return new BufferTransferableData(buffer, source);
}