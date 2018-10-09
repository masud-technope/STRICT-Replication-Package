//}}}
//{{{ getResourceAsStream() method
/**
	 * Returns an input stream to the specified resource, or <code>null</code>
	 * if none is found.
	 * 
	 * @param pluginClassName the plugin class name (fully qualified)
	 * @param path The path to the resource to be returned, relative to
	 * the plugin's resource path.
	 * @return An input stream for the resource, or <code>null</code>.
	 * @since 4.3pre10
	 * @see #getPluginHome
	 * @see #getResourceAsOutputStream
	 * @see #getResourcePath
	 */
private static InputStream getResourceAsStream(String pluginClassName, String path) {
    try {
        File file = getResourcePath(pluginClassName, path);
        if (file == null || !file.exists())
            return null;
        return new FileInputStream(file);
    } catch (IOException e) {
        return null;
    }
}