//}}}
//{{{ refreshList
private void refreshList() {
    DefaultListModel<String> registerModel = (DefaultListModel<String>) registerList.getModel();
    String o = registerList.getSelectedValue();
    int selected = -1;
    if (o != null && o.length() == 1)
        selected = o.charAt(0);
    registerModel.removeAllElements();
    Registers.Register[] registers = Registers.getRegisters();
    int index = 0;
    for (int i = 0; i < registers.length; i++) {
        Registers.Register reg = registers[i];
        if (reg == null)
            continue;
        if (i == '%')
            continue;
        String value = reg.toString();
        if (// || value.length() == 0)
        value == null)
            continue;
        if (i == selected)
            index = registerModel.size();
        registerModel.addElement(String.valueOf((char) i));
    }
    if (registerModel.getSize() == 0) {
        registerModel.addElement(jEdit.getProperty("view-registers.none"));
        registerList.setEnabled(false);
    } else
        registerList.setEnabled(true);
    registerList.setSelectedIndex(index);
}