//}}}
//{{{ passKeyEventToView() method
private void passKeyEventToView(KeyEvent e) {
    // Remove intercepter to avoid infinite recursion.
    assert (view.getKeyEventInterceptor() == keyHandler);
    view.setKeyEventInterceptor(null);
    // Here depends on an implementation detail.
    // Use ACTION_BAR to force processing KEY_TYPED event in
    // the implementation of gui.InputHandler.processKeyEvent().
    view.getInputHandler().processKeyEvent(e, View.ACTION_BAR, false);
    // The key event might trigger dispose() of this popup.
    if (this.isDisplayable()) {
        view.setKeyEventInterceptor(keyHandler);
    }
}