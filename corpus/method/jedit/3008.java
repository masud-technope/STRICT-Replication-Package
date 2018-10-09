//}}}
//{{{ getResourceAsOutputStream() method
/**
	 * Returns an output stream to the specified resource, or <code>null</node> if access
	 * to that resource is denied.
	 * 
	 * @param pluginClassName the plugin class name (fully qualified)
	 * @param path The path to the resource to be returned, relative to
	 * the plugin's resource path.
	 * @return An output stream for the resource, or <code>null</code>.
	 * @since 4.3pre10
	 * @see #getPluginHome
	 * @see #getResourceAsStream
	 * @see #getResourcePath
	 */
private static OutputStream getResourceAsOutputStream(String pluginClassName, String path) {
    try {
        File file = getResourcePath(pluginClassName, path);
        if (file == null)
            return null;
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            if (!parentFile.mkdirs()) {
                Log.log(Log.ERROR, EditPlugin.class, "Unable to create folder " + parentFile.getPath());
                return null;
            }
        }
        return new FileOutputStream(file);
    } catch (IOException e) {
        return null;
    }
}