//}}}
//{{{ getResourcePath() method
/**
	 * <p>Returns the full path of the specified plugin resource.</p>
	 *
	 * <p>This method doesn't need the plugin to be activated. You can pass
	 * an {@code EditPlugin.Deferred} instance that you get from
	 * {@code jEdit.getPlugin(String)} or {@code jEdit.getPlugins()} if
	 * the plugin in question is not activated yet and this method doesn't
	 * cause the plugin to get activated. If you have a reference to the
	 * plugins {@code Class} instance available, consider using the
	 * {@code Class} method.</p>
	 *
	 * @param plugin the plugin
	 * @param path The relative path to the resource from the plugin's
	 * resource path.
	 * @return The absolute path to the resource or null if there is no plugin home.
	 * @since 4.3pre10
	 * @see #getPluginHome
	 * @see #getResourceAsOutputStream
	 * @see #getResourceAsStream
	 * @see #getResourcePath(Class,String)
	 */
public static File getResourcePath(EditPlugin plugin, String path) {
    return getResourcePath(plugin.getClassName(), path);
}