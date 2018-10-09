@Override
public void processKeyEvent(KeyEvent evt) {
    evt = KeyEventWorkaround.processKeyEvent(evt);
    if (evt == null)
        return;
    switch(evt.getID()) {
        case KeyEvent.KEY_TYPED:
            char ch = evt.getKeyChar();
            if (!nonDigit && Character.isDigit(ch)) {
                super.processKeyEvent(evt);
                repeat = true;
                repeatCount = Integer.parseInt(action.getText());
            } else {
                nonDigit = true;
                if (repeat) {
                    passToView(evt);
                } else
                    super.processKeyEvent(evt);
            }
            break;
        case KeyEvent.KEY_PRESSED:
            int keyCode = evt.getKeyCode();
            if (evt.isActionKey() || evt.isControlDown() || evt.isAltDown() || evt.isMetaDown() || keyCode == KeyEvent.VK_BACK_SPACE || keyCode == KeyEvent.VK_DELETE || keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_TAB || keyCode == KeyEvent.VK_ESCAPE) {
                nonDigit = true;
                if (repeat) {
                    passToView(evt);
                    break;
                } else if (keyCode == KeyEvent.VK_TAB) {
                    complete(true);
                    evt.consume();
                } else if (keyCode == KeyEvent.VK_ESCAPE) {
                    evt.consume();
                    if (popup != null) {
                        popup.dispose();
                        popup = null;
                        action.requestFocus();
                    } else {
                        if (temp)
                            view.removeToolBar(ActionBar.this);
                        view.getEditPane().focusOnTextArea();
                    }
                    break;
                } else if ((keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN) && popup != null) {
                    popup.list.processKeyEvent(evt);
                    break;
                }
            }
            super.processKeyEvent(evt);
            break;
    }
}