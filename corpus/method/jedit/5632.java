@Override
public void tableChanged(TableModelEvent e) {
    if (isDownloadingList())
        return;
    setEnabled(pluginModel.getRowCount() != 0);
    if (e.getType() == TableModelEvent.UPDATE) {
        int length = pluginModel.getRowCount();
        for (int i = 0; i < length; i++) if (!((Boolean) pluginModel.getValueAt(i, 0)).booleanValue()) {
            setSelected(false);
            return;
        }
        if (length > 0)
            setSelected(true);
    }
}