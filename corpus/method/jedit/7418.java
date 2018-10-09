@Override
public boolean canImport(JComponent c, DataFlavor[] flavors) {
    JEditTextArea textArea = (JEditTextArea) c;
    // correctly handle text flavor + file list flavor
    // + text area read only, do an or of all flags
    boolean returnValue = false;
    for (DataFlavor flavor : flavors) {
        if (flavor.equals(DataFlavor.javaFileListFlavor) || isUriList(flavor)) {
            returnValue = true;
            break;
        } else if (flavor.equals(DataFlavor.stringFlavor)) {
            if (textArea.isEditable()) {
                returnValue = true;
                break;
            }
        }
    }
    Log.log(Log.DEBUG, this, "canImport() returning " + returnValue);
    return returnValue;
}