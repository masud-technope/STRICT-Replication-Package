protected void uninstallMouseMotionHook() {
    MouseMotionListener[] listeners = header.getMouseMotionListeners();
    for (int i = 0; i < listeners.length; i++) {
        MouseMotionListener l = listeners[i];
        if (l == this) {
            listeners[i] = mouseMotionDelegate;
        }
        header.removeMouseMotionListener(l);
    }
    for (MouseMotionListener l : listeners) {
        header.addMouseMotionListener(l);
    }
}