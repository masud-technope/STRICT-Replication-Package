//}}}
// {{{ addButton method
public void addButton(JButton button) {
    if (button != null) {
        buttonsBox.add(createHorizontalStrut(12));
        buttonsBox.add(button);
    }
}