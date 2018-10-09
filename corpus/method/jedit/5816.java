//}}}
//{{{ shouldUpdatePluginList()
/**
	* Check if the plugin list should be updated.
	* It will return <code>true</code> if the pluginList is <code>null</code>
	* or if the mirror id of the current plugin list is not the current preferred mirror id
	* and will return always false if the plugin list is currently downloading
	*
	* @return true if the plugin list should be updated
	*/
private boolean shouldUpdatePluginList() {
    return (pluginList == null || !pluginList.getMirrorId().equals(jEdit.getProperty("plugin-manager.mirror.id"))) && !downloadingPluginList;
}