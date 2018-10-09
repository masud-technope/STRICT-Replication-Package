//}}}
//{{{ getPluginHome() method
/**
	 * <p>Returns the home of the specified plugin.</p>
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
	 * @return the plugin home. It can be null if there is no settings directory
	 * @since 4.3pre10
	 * @see #getPluginHome(Class)
	 * @see #getResourceAsStream
	 * @see #getResourceAsOutputStream
	 * @see #getResourcePath
	 */
@Nullable
public static File getPluginHome(EditPlugin plugin) {
    return getPluginHome(plugin.getClassName());
}