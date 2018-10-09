protected void installMouseHook() {
    MouseListener[] listeners = header.getMouseListeners();
    for (int i = 0; i < listeners.length; i++) {
        MouseListener l = listeners[i];
        if (l.getClass().getName().contains("TableHeaderUI")) {
            this.mouseDelegate = l;
            listeners[i] = this;
        }
        header.removeMouseListener(l);
    }
    for (MouseListener l : listeners) {
        header.addMouseListener(l);
    }
}