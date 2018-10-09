//}}}
//{{{ activateIfNecessary() method
/**
	 * Should be called after a new plugin is installed.
	 * @since jEdit 4.2pre2
	 */
public void activatePluginIfNecessary() {
    String filename = MiscUtilities.getFileName(getPath());
    jEdit.unsetProperty("plugin-blacklist." + filename);
    if (!(plugin instanceof EditPlugin.Deferred && plugin != null)) {
        return;
    }
    String className = plugin.getClassName();
    // default for plugins that don't specify this property (ie,
    // 4.1-style plugins) is to load them on startup
    String activate = jEdit.getProperty("plugin." + className + ".activate");
    if (activate == null) {
        // 4.1 plugin
        if (!jEdit.isMainThread()) {
            breakPlugin();
            jEdit.pluginError(path, "plugin-error.not-42", null);
        } else {
            activatePlugin();
        }
    } else {
        // 4.2 plugin
        // if at least one property listed here is true,
        // load the plugin
        boolean load = false;
        StringTokenizer st = new StringTokenizer(activate);
        while (st.hasMoreTokens()) {
            String prop = st.nextToken();
            boolean value = jEdit.getBooleanProperty(prop);
            if (value) {
                Log.log(Log.DEBUG, this, "Activating " + className + " because of " + prop);
                load = true;
                break;
            }
        }
        if (load) {
            activatePlugin();
        }
    }
}