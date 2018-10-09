//}}}
//{{{ getResourcePath() method
/**
	 * <p>Returns the full path of the specified plugin resource.</p>
	 *
	 * <p>Since the first parameter is a reference to the
	 * {@code Class} instance for the plugin,
	 * this method requires the plugin to be activated.</p>
	 *
	 * <p>See {@link #getResourcePath(EditPlugin,String)} method, as
	 * an alternate, for when the plugin doesn't need
	 * to be activated, or when you do not have the
	 * {@code Class} instance available.</p>
	 *
	 * @param clazz the plugin class
	 * @param path The relative path to the resource from the plugin's
	 * resource path.
	 * @return The absolute path to the resource or null if there is no plugin home.
	 * @since 4.3pre10
	 * @see #getPluginHome
	 * @see #getResourceAsOutputStream
	 * @see #getResourceAsStream
	 * @see #getResourcePath(EditPlugin,String)
	 */
public static File getResourcePath(Class<? extends EditPlugin> clazz, String path) {
    return getResourcePath(clazz.getName(), path);
}