private void addDnD() {
    ComboBoxUI ui = getUI();
    if (ui instanceof BasicComboBoxUI) {
        Accessible acc = ui.getAccessibleChild(null, 0);
        if (acc instanceof BasicComboPopup) {
            JList list = ((BasicComboPopup) acc).getList();
            list.setDragEnabled(true);
            list.setDropMode(DropMode.INSERT);
            list.setTransferHandler(new BufferSwitcherTransferHandler());
        }
    }
}