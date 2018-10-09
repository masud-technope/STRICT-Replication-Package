public  BufferSwitcher(final EditPane editPane) {
    this.editPane = editPane;
    //setFont(new Font("Dialog",Font.BOLD,10));
    setTransferHandler(new ComboBoxTransferHandler(this));
    setRenderer(new BufferCellRenderer());
    setMaximumRowCount(jEdit.getIntegerProperty("bufferSwitcher.maxRowCount", 10));
    addPopupMenuListener(new PopupMenuListener() {

        @Override
        public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            itemSelectedBefore = getSelectedItem();
        }

        @Override
        public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
            if (!updating) {
                Buffer buffer = (Buffer) getSelectedItem();
                if (buffer != null)
                    editPane.setBuffer(buffer);
            }
            editPane.getTextArea().requestFocus();
        }

        @Override
        public void popupMenuCanceled(PopupMenuEvent e) {
            setSelectedItem(itemSelectedBefore);
        }
    });
    EditBus.addToBus(this);
    addItemListener(new ItemListener() {

        @Override
        public void itemStateChanged(ItemEvent evt) {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                Buffer buffer = (Buffer) evt.getItem();
                updateStyle(buffer);
            }
        }
    });
    defaultColor = getForeground();
    defaultBGColor = getBackground();
    updateStyle(editPane.getBuffer());
}