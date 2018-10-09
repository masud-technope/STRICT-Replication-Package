//}}}
//{{{ updatePluginList() method
private void updatePluginList() {
    if (jEdit.getSettingsDirectory() == null && jEdit.getJEditHome() == null) {
        GUIUtilities.error(this, "no-settings", null);
        return;
    }
    if (!shouldUpdatePluginList()) {
        return;
    }
    installer.loading();
    updater.loading();
    ThreadUtilities.runInBackground(new Task() {

        @Override
        public void _run() {
            try {
                downloadingPluginList = true;
                setStatus(jEdit.getProperty("plugin-manager.list-download-connect"));
                pluginList = new PluginList(this);
            } finally {
                downloadingPluginList = false;
            }
            ThreadUtilities.runInDispatchThread(new Runnable() {

                public void run() {
                    pluginListUpdated();
                }
            });
        }
    });
}