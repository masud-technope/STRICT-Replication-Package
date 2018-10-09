//}}}
//{{{ getResourceAsStream() method
/**
	 * <p>Returns an input stream to the specified resource, or <code>null</code>
	 * if none is found.</p>
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
	 * @param path The path to the resource to be returned, relative to
	 * the plugin's resource path.
	 * @return An input stream for the resource, or <code>null</code>.
	 * @since 4.3pre10
	 * @see #getPluginHome
	 * @see #getResourceAsStream(Class,String)
	 * @see #getResourceAsOutputStream
	 * @see #getResourcePath
	 */
public static InputStream getResourceAsStream(EditPlugin plugin, String path) {
    return getResourceAsStream(plugin.getClassName(), path);
}