//}}}
//{{{ isDataFlavorSupported() method
public boolean isDataFlavorSupported(DataFlavor flavor) {
    return jEditFileList.equals(flavor) || DataFlavor.stringFlavor.equals(flavor);
}