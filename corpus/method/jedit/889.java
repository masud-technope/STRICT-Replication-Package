protected void installMouseMotionHook() {
    MouseMotionListener[] listeners = header.getMouseMotionListeners();
    for (int i = 0; i < listeners.length; i++) {
        MouseMotionListener l = listeners[i];
        if (l.getClass().getName().contains("TableHeaderUI")) {
            this.mouseMotionDelegate = l;
            listeners[i] = this;
        }
        header.removeMouseMotionListener(l);
    }
    for (MouseMotionListener l : listeners) {
        header.addMouseMotionListener(l);
    }
}