@Override
public DataFlavor[] getTransferDataFlavors() {
    return Arrays.copyOf(supportedDataFlavor, supportedDataFlavor.length);
}