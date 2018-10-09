public void update() {
    Buffer buffer = view.getBuffer();
    String indent = buffer.getStringProperty("autoIndent");
    this.indent.setToolTipText(jEdit.getProperty("view.status.indent-tooltip"));
    if ("full".equals(indent)) {
        this.indent.setEnabled(true);
        this.indent.setText("F");
    } else if ("simple".equals(indent)) {
        this.indent.setEnabled(true);
        this.indent.setText("S");
    } else {
        this.indent.setEnabled(false);
        this.indent.setText("n");
    }
}