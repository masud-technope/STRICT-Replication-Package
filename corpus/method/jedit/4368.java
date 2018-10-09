public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    super.getListCellRendererComponent(list, null, index, isSelected, cellHasFocus);
    if (value instanceof String) {
        setIcon(null);
        setText((String) value);
    } else {
        Result result = (Result) value;
        setIcon(new ResultIcon(result.rank));
        setText(result.title);
    }
    return this;
}