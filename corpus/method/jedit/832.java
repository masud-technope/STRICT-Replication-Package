public void keyPressed(KeyEvent e) {
    if ((e.getKeyCode() == KeyEvent.VK_DOWN) || (e.getKeyCode() == KeyEvent.VK_ENTER)) {
        doPopup();
        e.consume();
        return;
    }
}