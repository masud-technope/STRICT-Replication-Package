//}}}
//{{{ getResourcePath() method
/**
	 * Returns the full path of the specified plugin resource.
	 *
	 * @param pluginClassName the plugin class name (fully qualified)
	 * @param path The relative path to the resource from the plugin's
	 * resource path.
	 * @return The absolute path to the resource or null if there is no plugin home.
	 * @since 4.3pre10
	 * @see #getPluginHome
	 * @see #getResourceAsOutputStream
	 * @see #getResourceAsStream
	 */
@Nullable
private static File getResourcePath(String pluginClassName, String path) {
    File home = getPluginHome(pluginClassName);
    if (home == null)
        return null;
    return new File(home, path);
}