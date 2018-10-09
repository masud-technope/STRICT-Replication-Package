// }}}
// {{{ getFiles() method
/**
	 * Get the files listed in this plugin and return full paths to them
	 *
	 * @return files full paths or empty collection if plugin is null
	 * @since jEdit 5.3pre1
	 */
public Collection<String> getFiles() {
    if (plugin != null) {
        String files = jEdit.getProperty("plugin." + plugin.getClassName() + ".files");
        if (files != null) {
            return parseJarsFilesString(path, files);
        }
    }
    return Collections.emptyList();
}