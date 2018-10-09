//{{{ getPluginHome() method
/**
	 * Returns the home of your plugin.
	 *
	 * @return the plugin home. It can be null if there is no 
	 *	   settings directory
	 * @since 4.3pre10
	 * @see #getResourceAsStream
	 * @see #getResourceAsOutputStream
	 * @see #getResourcePath
	 */
@Nullable
public File getPluginHome() {
    return getPluginHome(getClassName());
}