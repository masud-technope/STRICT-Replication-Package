//{{{ keyPressed() method
@Override
public void keyPressed(KeyEvent e) {
    CompletionPopup.this.keyPressed(e);
    if (candidates == null || !candidates.isValid()) {
        dispose();
    } else if (!e.isConsumed()) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_TAB:
            case KeyEvent.VK_ENTER:
                if (doSelectedCompletion()) {
                    e.consume();
                } else {
                    dispose();
                }
                break;
            case KeyEvent.VK_ESCAPE:
                dispose();
                e.consume();
                break;
            case KeyEvent.VK_UP:
                moveRelative(-1);
                e.consume();
                break;
            case KeyEvent.VK_DOWN:
                moveRelative(1);
                e.consume();
                break;
            case KeyEvent.VK_P:
                if ((e.getModifiersEx() & InputEvent.CTRL_DOWN_MASK) == InputEvent.CTRL_DOWN_MASK) {
                    moveRelative(-1);
                    e.consume();
                }
                break;
            case KeyEvent.VK_N:
                if ((e.getModifiersEx() & InputEvent.CTRL_DOWN_MASK) == InputEvent.CTRL_DOWN_MASK) {
                    moveRelative(1);
                    e.consume();
                }
                break;
            case KeyEvent.VK_PAGE_UP:
                moveRelativePages(-1);
                e.consume();
                break;
            case KeyEvent.VK_PAGE_DOWN:
                moveRelativePages(1);
                e.consume();
                break;
            default:
                if (e.isActionKey() || e.isAltDown() || e.isMetaDown() || e.isControlDown()) {
                    dispose();
                }
                break;
        }
    }
    if (!e.isConsumed()) {
        passKeyEventToView(e);
    }
//}}}
}