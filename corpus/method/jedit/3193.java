//{{{ keyTyped() method
@Override
public void keyTyped(KeyEvent e) {
    if (e.isControlDown()) {
        e.consume();
    } else {
        CompletionPopup.this.keyTyped(e);
    }
    if (candidates == null || !candidates.isValid()) {
        dispose();
    }
    if (!e.isConsumed()) {
        passKeyEventToView(e);
    }
//}}}
}