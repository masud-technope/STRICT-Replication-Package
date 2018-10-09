void doPopup() {
    if (popup == null)
        createPopupMenu();
    GenericGUIUtilities.showPopupMenu(popup, this, 0, getHeight(), false);
}