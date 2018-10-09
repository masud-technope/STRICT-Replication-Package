@Override
public void keyPressed(KeyEvent evt) {
    int keyCode = evt.getKeyCode();
    if (keyCode == KeyEvent.VK_ESCAPE)
        action.processKeyEvent(evt);
    else if (keyCode == KeyEvent.VK_ENTER)
        invoke();
    else if (keyCode == KeyEvent.VK_UP) {
        int selected = list.getSelectedIndex();
        if (selected == 0) {
            list.setSelectedIndex(list.getModel().getSize() - 1);
            evt.consume();
        }
    } else if (keyCode == KeyEvent.VK_DOWN) {
        int selected = list.getSelectedIndex();
        if (selected == list.getModel().getSize() - 1) {
            list.setSelectedIndex(0);
            evt.consume();
        }
    }
}