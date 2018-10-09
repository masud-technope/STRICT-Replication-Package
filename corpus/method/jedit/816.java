// BrowserCommandsMenu popup;
void doPopup() {
    ((BrowserCommandsMenu) popup).update();
    GenericGUIUtilities.showPopupMenu(popup, this, 0, getHeight(), false);
}