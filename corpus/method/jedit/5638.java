@Override
public void tableChanged(TableModelEvent e) {
    if (e.getType() == TableModelEvent.UPDATE) {
        if (isDownloadingList())
            return;
        size = 0;
        nbPlugins = 0;
        int length = pluginModel.entries.size();
        for (int i = 0; i < length; i++) {
            Entry entry = (Entry) pluginModel.entries.get(i);
            if (entry.install) {
                nbPlugins++;
                size += entry.size;
            }
        }
        update();
    }
}