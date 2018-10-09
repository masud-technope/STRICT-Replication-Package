public void valueChanged(ListSelectionEvent e) {
    List<Mode> modes = pingPongList.getRightSelectedValues();
    boolean enabled = false;
    for (Mode m : modes) {
        if (m.isUserMode()) {
            enabled = true;
            break;
        }
    }
    deleteSelectedButton.setEnabled(enabled);
}