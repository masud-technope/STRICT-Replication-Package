public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    if (value instanceof Marker) {
        Marker mark = (Marker) value;
        JEditTextArea textArea = view.getTextArea();
        int pos = textArea.getLineOfOffset(mark.getPosition());
        String txt = view.getTextArea().getLineText(pos);
        if (txt.equals(""))
            txt = jEdit.getProperty("markers.blank-line");
        char shortcut_char = mark.getShortcut();
        String shortcut = "";
        if (shortcut_char > 0)
            shortcut = "[" + shortcut_char + "]";
        setText((pos + 1) + " " + shortcut + ": " + txt);
    }
    return this;
}