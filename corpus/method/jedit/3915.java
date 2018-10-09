private void dataUpdated() {
    selectAllButton.setEnabled(getLeftSize() != 0);
    selectNoneButton.setEnabled(getRightSize() != 0);
}