@Override
public void actionPerformed(ActionEvent ae) {
    Object source = ae.getSource();
    if (source == selectAllButton) {
        moveAllToRight();
        selectAllButton.setEnabled(false);
        selectNoneButton.setEnabled(true);
    } else if (source == selectNoneButton) {
        moveAllToLeft();
        selectAllButton.setEnabled(true);
        selectNoneButton.setEnabled(false);
    }
}