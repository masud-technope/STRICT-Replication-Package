//}}}
//{{{ getTextFromTransferable() method
private static String getTextFromTransferable(Transferable transferable, DataFlavor dataFlavor) {
    try {
        Object data = transferable.getTransferData(dataFlavor);
        return stripEOLChars(data.toString());
    } catch (UnsupportedFlavorException e) {
        Log.log(Log.ERROR, Registers.class, e);
    } catch (IOException e) {
        Log.log(Log.ERROR, Registers.class, e);
    }
    return null;
}