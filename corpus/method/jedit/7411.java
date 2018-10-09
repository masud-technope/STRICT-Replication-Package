//}}}
//{{{ importData
@Override
public boolean importData(JComponent c, Transferable t) {
    Log.log(Log.DEBUG, this, "Import data");
    //		Log.log(Log.DEBUG,this,"Import data: t.isDataFlavorSupported("+textURIlistDataFlavor+")="+t.isDataFlavorSupported(textURIlistDataFlavor)+".");
    if (!canImport(c, t.getTransferDataFlavors()))
        return false;
    boolean returnValue;
    try {
        if (t.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
            returnValue = importFile(c, t);
        } else {
            DataFlavor uriListStringDataFlavor = null;
            DataFlavor[] dataFlavors = t.getTransferDataFlavors();
            for (DataFlavor dataFlavor : dataFlavors) {
                if (isUriList(dataFlavor)) {
                    uriListStringDataFlavor = dataFlavor;
                    break;
                }
            }
            if (uriListStringDataFlavor != null && t.isDataFlavorSupported(uriListStringDataFlavor)) {
                returnValue = importURIList(c, t, uriListStringDataFlavor);
            } else {
                returnValue = importText(c, t);
            }
        }
    } catch (Exception e) {
        Log.log(Log.ERROR, this, e);
        returnValue = false;
    }
    GUIUtilities.getView(c).toFront();
    GUIUtilities.getView(c).requestFocus();
    c.requestFocus();
    return returnValue;
}