@Override
public void keyPressed(KeyEvent evt) {
    switch(evt.getKeyCode()) {
        case KeyEvent.VK_ESCAPE:
            if (isRemovable) {
                view.removeToolBar(SearchBar.this);
            }
            evt.consume();
            view.getEditPane().focusOnTextArea();
            break;
        case KeyEvent.VK_ENTER:
            if (evt.isShiftDown()) {
                evt.consume();
                find(true);
            }
            break;
    }
}