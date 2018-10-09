//{{{ setValueAt() method
@Override
public void setValueAt(final Object value, int rowIndex, final int columnIndex) {
    final Entry entry = entries.get(rowIndex);
    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            if (columnIndex == 0) {
                PluginJAR jar = jEdit.getPluginJAR(entry.jar);
                if (jar == null) {
                    if (value.equals(Boolean.FALSE))
                        return;
                    PluginJAR load = PluginJAR.load(entry.jar, true);
                    if (load == null) {
                        GUIUtilities.error(ManagePanel.this, "plugin-load-error", null);
                    }
                } else {
                    if (value.equals(Boolean.TRUE))
                        return;
                    unloadPluginJARWithDialog(jar);
                }
            }
            update();
        }
    });
//}}}
}