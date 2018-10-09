// }}}
//{{{ getJars() method
/**
	 * Get the jars listed in this plugin and return full paths to them
	 *
	 * @return jars full paths or empty collection if plugin is null
	 * @since jEdit 5.3pre1
	 */
public Collection<String> getJars() {
    if (plugin != null) {
        String jars = jEdit.getProperty("plugin." + plugin.getClassName() + ".jars");
        if (jars != null) {
            return parseJarsFilesString(path, jars);
        }
    }
    return Collections.emptyList();
}