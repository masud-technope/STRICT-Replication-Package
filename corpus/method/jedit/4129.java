//}}}
//{{{ propertiesChanged() method
public void propertiesChanged() {
    Color fg = jEdit.getColorProperty("view.status.foreground");
    Color bg = jEdit.getColorProperty("view.status.background");
    showCaretStatus = jEdit.getBooleanProperty("view.status.show-caret-status");
    panel.setBackground(bg);
    panel.setForeground(fg);
    caretStatus.setBackground(bg);
    caretStatus.setForeground(fg);
    message.setBackground(bg);
    message.setForeground(fg);
    // retarded GTK look and feel!
    Font font = new JLabel().getFont();
    //UIManager.getFont("Label.font");
    FontMetrics fm = getFontMetrics(font);
    if (showCaretStatus) {
        panel.add(BorderLayout.WEST, caretStatus);
        caretStatus.setFont(font);
        Dimension dim = new Dimension(fm.stringWidth(caretTestStr), fm.getHeight());
        caretStatus.setPreferredSize(dim);
        updateCaretStatus();
    } else
        panel.remove(caretStatus);
    String statusBar = jEdit.getProperty("view.status");
    if (!Objects.equals(currentBar, statusBar)) {
        box.removeAll();
        StringTokenizer tokenizer = new StringTokenizer(statusBar);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (Character.isLetter(token.charAt(0))) {
                Widget widget = getWidget(token);
                if (widget == null) {
                    JLabel label = new JLabel(token);
                    label.setBackground(bg);
                    label.setForeground(fg);
                    box.add(label);
                    continue;
                }
                Component c = widget.getComponent();
                c.setBackground(bg);
                c.setForeground(fg);
                box.add(c);
                widget.update();
                widget.propertiesChanged();
            } else {
                JLabel label = new JLabel(token);
                label.setBackground(bg);
                label.setForeground(fg);
                box.add(label);
            }
        }
        currentBar = statusBar;
    }
    updateBufferStatus();
    updateMiscStatus();
}