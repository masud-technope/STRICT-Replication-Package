@Override
public void actionPerformed(ActionEvent e) {
    int[] ints = table.getSelectedRows();
    List<String> list = new ArrayList<String>(ints.length);
    List<Entry> entries = new ArrayList<Entry>(ints.length);
    for (int i = 0; i < ints.length; i++) {
        Entry entry = pluginModel.getEntry(ints[i]);
        if (entry.plugin != null) {
            list.add(entry.name);
            entries.add(entry);
        }
    }
    String[] strings = list.toArray(new String[list.size()]);
    int ret = GUIUtilities.listConfirm(ManagePanel.this, "plugin-manager.cleanup", null, strings);
    if (ret != JOptionPane.OK_OPTION)
        return;
    for (int i = 0; i < entries.size(); i++) {
        Entry entry = entries.get(i);
        File path = entry.plugin.getPluginHome();
        Log.log(Log.NOTICE, this, "Removing data of plugin " + entry.name + " home=" + path);
        FileVFS.recursiveDelete(path);
        entry.dataSize = null;
    }
    table.repaint();
}