@Override
public void keyPressed(KeyEvent evt) {
    if (evt.getKeyCode() == KeyEvent.VK_SPACE || evt.getKeyCode() == KeyEvent.VK_ENTER) {
        evt.consume();
        goToSelectedMarker();
    }
}