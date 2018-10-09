public boolean canImport(TransferHandler.TransferSupport info) {
    // we only import Strings
    if (!info.isDataFlavorSupported(BufferSwitcher.BufferDataFlavor)) {
        return false;
    }
    if (!comboBox.isPopupVisible()) {
        comboBox.showPopup();
    }
    return false;
}