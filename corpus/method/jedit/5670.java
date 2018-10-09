//}}}
//{{{ updateModel() method
/**
	 * Must be called from the EDT.
	 **/
public void updateModel() {
    infoBox.setText(null);
    pluginModel.update();
    if (pluginModel.getRowCount() == 0) {
        if (updates)
            layout.show(InstallPanel.this, "PLUGIN_ARE_UP_TO_DATE");
        else
            layout.show(InstallPanel.this, "NO_PLUGIN_AVAILABLE");
    } else {
        layout.show(InstallPanel.this, "INSTALL");
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                searchField.requestFocusInWindow();
            }
        });
    }
    isLoading = false;
}