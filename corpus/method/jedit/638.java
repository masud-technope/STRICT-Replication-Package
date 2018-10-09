/**
	 * Creates a new action set.
	 * @param plugin The plugin
	 * @param cachedActionNames The list of cached action names
	 * @param cachedActionToggleFlags The list of cached action toggle flags
	 * @param uri The actions.xml URI
	 * @since jEdit 4.2pre2
	 */
public  ActionSet(PluginJAR plugin, String[] cachedActionNames, boolean[] cachedActionToggleFlags, URL uri) {
    this();
    this.plugin = plugin;
    this.uri = uri;
    if (cachedActionNames != null) {
        for (int i = 0; i < cachedActionNames.length; i++) {
            actions.put(cachedActionNames[i], placeholder);
            jEdit.setTemporaryProperty(cachedActionNames[i] + ".toggle", cachedActionToggleFlags[i] ? "true" : "false");
        }
    }
    loaded = false;
}