@Override
public boolean isDataFlavorSupported(DataFlavor flavor) {
    return flavor.equals(javaListFlavor);
}