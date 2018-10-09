private void handleKeyEvent(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        skipDrain = false;
        Collections.rotate(vLines, -1);
    } else if (e.getKeyCode() == KeyEvent.VK_UP) {
        skipDrain = false;
        Collections.rotate(vLines, 1);
    } else if ((e.getKeyCode() == KeyEvent.VK_LEFT) || (e.getKeyCode() == KeyEvent.VK_RIGHT) || (e.getKeyCode() == KeyEvent.VK_SPACE)) {
        skipDrain = !skipDrain;
        e.consume();
    } else if ((e.getKeyCode()) == KeyEvent.VK_ESCAPE) {
        e.consume();
        JDialog d = GenericGUIUtilities.getParentDialog(this);
        stopThread();
        d.dispose();
    }
}