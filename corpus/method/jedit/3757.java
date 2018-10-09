// This is the only method defined by ListCellRenderer.
@Override
public Component getListCellRendererComponent(JList<? extends String> list, // value to display
String value, // cell index
int index, // is the cell selected
boolean isSelected, // the list and the cell have the focus
boolean cellHasFocus) {
    if (value == null)
        value = "";
    text = value;
    if (isSelected) {
        setBackground(list.getSelectionBackground());
        setForeground(list.getSelectionForeground());
    } else {
        setBackground(list.getBackground());
        Color color = list.getForeground();
        if (text.contains("[debug]")) {
            color = debugColor;
        } else if (text.contains("[message]")) {
            color = messageColor;
        } else if (text.contains("[notice]")) {
            color = noticeColor;
        } else if (text.contains("[warning]")) {
            color = warningColor;
        } else if (text.contains("[error]")) {
            color = errorColor;
        }
        setForeground(color);
    }
    return this;
}