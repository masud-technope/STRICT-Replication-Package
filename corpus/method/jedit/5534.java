//}}}
//{{{ updateButtons() method
private void updateButtons() {
    int index = list.getSelectedIndex();
    remove.setEnabled(index != -1 && listModel.getSize() != 0);
    moveUp.setEnabled(index > 0);
    moveDown.setEnabled(index != -1 && index != listModel.getSize() - 1);
    edit.setEnabled(index != -1);
}