public Component getCellRenderer(JList list, int index, boolean isSelected, boolean cellHasFocus) {
    renderer.getListCellRendererComponent(list, null, index, isSelected, cellHasFocus);
    Completion comp = completions[index];
    String text = comp.text;
    Font font = list.getFont();
    if (index < 9)
        text = (index + 1) + ": " + text;
    else if (index == 9)
        text = "0: " + text;
    if (comp.keyword)
        font = font.deriveFont(Font.BOLD);
    renderer.setText(text);
    renderer.setFont(font);
    return renderer;
}