//}}}
//{{{ clearSelectedIndex() method
private void clearSelectedIndex() {
    String o = registerList.getSelectedValue();
    if (o != null && o.length() == 1) {
        Registers.clearRegister(o.charAt(0));
        refreshList();
    }
}