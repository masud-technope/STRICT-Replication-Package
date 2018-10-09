public void update() {
    Buffer buffer = view.getBuffer();
    String wrap = buffer.getStringProperty("wrap");
    if (largeBufferDeactivateWrap() && "soft".equals(wrap)) {
        wrap = "none";
    }
    this.wrap.setToolTipText(jEdit.getProperty("view.status.wrap-tooltip", new String[] { jEdit.getProperty("wrap." + wrap) }));
    if ("none".equals(wrap)) {
        this.wrap.setEnabled(false);
        this.wrap.setText("n");
    } else {
        this.wrap.setEnabled(true);
        if ("hard".equals(wrap))
            this.wrap.setText("H");
        else if ("soft".equals(wrap))
            this.wrap.setText("S");
    }
}