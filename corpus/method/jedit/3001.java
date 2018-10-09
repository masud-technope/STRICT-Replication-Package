//}}}
//{{{ getPluginHome() method
/**
	 * <p>Returns the home of the specified plugin.</p>
	 *
	 * <p>Since the first parameter is a reference to the
	 * {@code Class} instance for the plugin,
	 * this method requires the plugin to be activated.</p>
	 *
	 * <p>See {@link #getPluginHome(EditPlugin)} method, as
	 * an alternate, for when the plugin doesn't need
	 * to be activated, or when you do not have the
	 * {@code Class} instance available.</p>
	 *
	 * @param clazz the class of the plugin
	 * @return the plugin home. It can be null if there is no
	 * 	   settings directory
	 * @since 4.3pre10
	 * @see #getPluginHome(EditPlugin)
	 * @see #getResourceAsStream
	 * @see #getResourceAsOutputStream
	 * @see #getResourcePath
	 */
@Nullable
public static File getPluginHome(Class<? extends EditPlugin> clazz) {
    return getPluginHome(clazz.getName());
}