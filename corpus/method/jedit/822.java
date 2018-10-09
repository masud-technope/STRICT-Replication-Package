@Override
public void mousePressed(MouseEvent evt) {
    if (popup == null || !popup.isVisible()) {
        doPopup();
    } else {
        popup.setVisible(false);
    }
}