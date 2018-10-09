@Override
public void valueChanged(ListSelectionEvent e) {
    if (table.getSelectedRowCount() == 1) {
        try {
            Entry entry = pluginModel.getEntry(table.getSelectedRow());
            String label = entry.clazz;
            String docs = entry.docs;
            if (label != null) {
                EditPlugin plug = jEdit.getPlugin(label, false);
                PluginJAR jar = null;
                if (plug != null)
                    jar = plug.getPluginJAR();
                if (jar != null && docs != null) {
                    URL url = jar.getClassLoader().getResource(docs);
                    if (url != null) {
                        docURL = url;
                        setEnabled(true);
                        return;
                    }
                }
            }
        } catch (Exception ex) {
            Log.log(Log.ERROR, this, "ManagePanel HelpButton Update", ex);
        }
    }
    setEnabled(false);
}