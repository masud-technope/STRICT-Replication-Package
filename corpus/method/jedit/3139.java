private void updateButtons() {
    int index = bufferList.getSelectedIndex();
    save.getModel().setEnabled(index != -1);
    discard.getModel().setEnabled(index != -1);
}