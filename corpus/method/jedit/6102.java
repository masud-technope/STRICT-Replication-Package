@Override
public String toString() {
    if (transferable == null)
        return null;
    if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
        try {
            return transferable.getTransferData(DataFlavor.stringFlavor).toString();
        } catch (UnsupportedFlavorException e) {
            Log.log(Log.ERROR, this, e);
        } catch (IOException e) {
            Log.log(Log.ERROR, this, e);
        }
    }
    return transferable.toString();
}