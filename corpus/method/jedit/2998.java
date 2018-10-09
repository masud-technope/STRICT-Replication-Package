//}}}
//{{{ getResourceAsStream() method
/**
	 * <p>Returns an input stream to the specified resource, or {@code null}
	 * if none is found.</p>
	 *
	 * <p>Since the first parameter is a reference to the
	 * {@code Class} instance for the plugin,
	 * this method requires the plugin to be activated.</p>
	 *
	 * <p>See {@link #getResourceAsStream(EditPlugin,String)} method, as
	 * an alternate, for when the plugin doesn't need
	 * to be activated, or when you do not have the
	 * {@code Class} instance available.</p>
	 *
	 * @param clazz the plugin class
	 * @param path The path to the resource to be returned, relative to
	 * the plugin's resource path.
	 * @return An input stream for the resource, or <code>null</code>.
	 * @since 4.3pre10
	 * @see #getPluginHome
	 * @see #getResourceAsStream(EditPlugin,String)
	 * @see #getResourceAsOutputStream
	 * @see #getResourcePath
	 */
public static InputStream getResourceAsStream(Class<? extends EditPlugin> clazz, String path) {
    return getResourceAsStream(clazz.getName(), path);
}