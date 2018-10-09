@Override
public void mouseReleased(MouseEvent evt) {
    if (evt.getClickCount() % 2 != 0 && !GenericGUIUtilities.isMiddleButton(evt.getModifiersEx()))
        return;
    int row = parentDirectories.locationToIndex(evt.getPoint());
    if (row != -1) {
        Object obj = parentDirectories.getModel().getElementAt(row);
        if (obj instanceof VFSFile) {
            VFSFile dirEntry = (VFSFile) obj;
            if (!GenericGUIUtilities.isPopupTrigger(evt)) {
                browser.setDirectory(dirEntry.getPath());
                if (browser.getMode() == VFSBrowser.BROWSER)
                    focusOnFileView();
            }
        }
    }
}