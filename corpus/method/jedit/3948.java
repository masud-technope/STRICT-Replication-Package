private void updateRegister() {
    String value = registerList.getSelectedValue();
    if (value == null || value.length() < 1)
        return;
    char name = value.charAt(0);
    Registers.setRegister(name, contentTextArea.getText());
}