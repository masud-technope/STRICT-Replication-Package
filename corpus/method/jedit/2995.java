//}}}
//{{{ getPluginHome() method
/**
	 * Returns the home of the specified plugin.
	 *
	 * @param pluginClassName the plugin class name (fully qualified)
	 * @return the plugin home. It can be null if there is no settings directory
	 * @since 4.3pre10
	 * @see #getResourceAsStream
	 * @see #getResourceAsOutputStream
	 * @see #getResourcePath
	 */
@Nullable
private static File getPluginHome(String pluginClassName) {
    String settingsDirectory = jEdit.getSettingsDirectory();
    if (settingsDirectory == null)
        return null;
    File file = new File(settingsDirectory, "plugins");
    if (!file.isDirectory()) {
        if (!file.mkdir()) {
            Log.log(Log.ERROR, EditPlugin.class, "Can't create directory:" + file.getAbsolutePath());
        }
    }
    return new File(file, pluginClassName);
}