//}}}
//{{{ debugListDataFlavors() method
protected static void debugListDataFlavors(Transferable transferable) {
    DataFlavor[] dataFlavors = transferable.getTransferDataFlavors();
    for (DataFlavor dataFlavor : dataFlavors) {
        Log.log(Log.DEBUG, Registers.class, "debugListDataFlavors(): dataFlavor=" + dataFlavor + '.');
    }
    if (dataFlavors.length == 0) {
        Log.log(Log.DEBUG, Registers.class, "debugListDataFlavors(): no dataFlavor supported.");
    }
}