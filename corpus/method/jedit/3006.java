//}}}
//{{{ getResourceAsOutputStream() method
/**
	 * <p>Returns an output stream to the specified resource, or {@code null}
	 * if access to that resource is denied.</p>
	 *
	 * <p>Since the first parameter is a reference to the
	 * {@code Class} instance for the plugin,
	 * this method requires the plugin to be activated.</p>
	 *
	 * <p>See {@link #getResourceAsOutputStream(EditPlugin,String)} method, as
	 * an alternate, for when the plugin doesn't need
	 * to be activated, or when you do not have the
	 * {@code Class} instance available.</p>
	 *
	 * @param clazz the plugin class
	 * @param path The path to the resource to be returned, relative to
	 * the plugin's resource path.
	 * @return An output stream for the resource, or <code>null</code>.
	 * @since 4.3pre10
	 * @see #getPluginHome
	 * @see #getResourceAsOutputStream(EditPlugin,String)
	 * @see #getResourceAsStream
	 * @see #getResourcePath
	 */
public static OutputStream getResourceAsOutputStream(Class<? extends EditPlugin> clazz, String path) {
    return getResourceAsOutputStream(clazz.getName(), path);
}