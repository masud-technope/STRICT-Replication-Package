public void update() {
    Buffer buffer = view.getBuffer();
    Boolean locked = buffer.isLocked();
    cmp.setText(locked ? "L" : "l");
    cmp.setEnabled(locked);
    cmp.setToolTipText(jEdit.getProperty("view.status.locked-tooltip", new Integer[] { locked ? 1 : 0 }));
}