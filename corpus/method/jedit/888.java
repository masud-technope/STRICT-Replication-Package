protected void uninstallMouseHook() {
    MouseListener[] listeners = header.getMouseListeners();
    for (int i = 0; i < listeners.length; i++) {
        MouseListener l = listeners[i];
        if (l == this) {
            listeners[i] = mouseDelegate;
        }
        header.removeMouseListener(l);
    }
    for (MouseListener l : listeners) {
        header.addMouseListener(l);
    }
}