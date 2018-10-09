public void valueChanged(ListSelectionEvent evt) {
    String value = registerList.getSelectedValue();
    if (value == null || value.length() < 1) {
        if (!editing) {
            contentTextArea.setText("");
            contentTextArea.setEditable(false);
        }
        return;
    }
    char name = value.charAt(0);
    Registers.Register reg = Registers.getRegister(name);
    if (reg == null) {
        if (!editing) {
            contentTextArea.setText("");
            contentTextArea.setEditable(false);
        }
        return;
    }
    if (!editing) {
        contentTextArea.setText(reg.toString());
        contentTextArea.setEditable(true);
        contentTextArea.setCaretPosition(0);
    }
}