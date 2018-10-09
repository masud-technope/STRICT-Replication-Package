@Override
public void valueChanged(ListSelectionEvent e) {
    int row = table.getSelectedRow();
    if (row != -1) {
        Entry entry = pluginModel.getEntry(row);
        pluginDetailPanel.setPlugin(entry);
    }
}