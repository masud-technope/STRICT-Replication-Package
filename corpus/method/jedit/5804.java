//{{{ pluginRemoved() method
/**
	 * A callback called by the @link ManagePanel} when a plugin is removed.
	 * In that case, if the plugin had an update, the updater has to remove it,
	 * and the installer panel has to show the plugin again.
	 */
void pluginRemoved() {
    updater.updateModel();
    installer.updateModel();
}