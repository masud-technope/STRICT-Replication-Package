//}}}
//{{{ processKeyEvent() method
public void processKeyEvents(KeyEvent ke) {
    if ((ke.getID() == KeyEvent.KEY_PRESSED) && (ke.getKeyCode() == KeyEvent.VK_ESCAPE)) {
        cancel();
        ke.consume();
    }
}