@Override
public boolean canImport(JComponent comp, DataFlavor[] transferFlavors) {
    return comp == left || comp == right;
}