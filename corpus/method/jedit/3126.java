@Override
public boolean isDataFlavorSupported(DataFlavor flavor) {
    return BufferSwitcher.BufferDataFlavor.equals(flavor);
}