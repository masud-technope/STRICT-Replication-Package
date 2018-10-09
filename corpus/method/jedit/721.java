@Override
public void mousePressed(MouseEvent evt) {
    int row = parentDirectories.locationToIndex(evt.getPoint());
    if (row != -1) {
        Object obj = parentDirectories.getModel().getElementAt(row);
        if (obj instanceof VFSFile) {
            VFSFile dirEntry = (VFSFile) obj;
            if (GenericGUIUtilities.isPopupTrigger(evt)) {
                if (popup != null && popup.isVisible()) {
                    popup.setVisible(false);
                    popup = null;
                } else {
                    parentDirectories.setSelectedIndex(row);
                    showFilePopup(new VFSFile[] { dirEntry }, parentDirectories, evt.getPoint());
                }
            }
        }
    }
}