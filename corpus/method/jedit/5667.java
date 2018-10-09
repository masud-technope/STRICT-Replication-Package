@Override
public void tableChanged(TableModelEvent e) {
    if (isDownloadingList())
        return;
    if (e.getType() == TableModelEvent.UPDATE) {
        int length = pluginModel.getRowCount();
        for (int i = 0; i < length; i++) if (((Boolean) pluginModel.getValueAt(i, 0)).booleanValue()) {
            setEnabled(true);
            return;
        }
        setEnabled(false);
    }
}