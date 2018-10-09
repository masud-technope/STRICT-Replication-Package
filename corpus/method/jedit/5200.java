/**
	 * Creates a new plugin update message.
	 * @param jar The plugin
	 * @param what What happened
	 * @param exit Is the editor exiting?
	 * @since jEdit 4.2pre3
	 */
public  PluginUpdate(PluginJAR jar, Object what, boolean exit) {
    super(jar);
    if (jar == null) {
        throw new IllegalArgumentException("PluginJAR may not be null.");
    }
    this.jar = jar;
    if (what == null)
        throw new NullPointerException("What must be non-null");
    EditPlugin plugin = jar.getPlugin();
    if (plugin != null) {
        String clazz = plugin.getClassName();
        version = jEdit.getProperty("plugin." + clazz + ".version");
    }
    this.what = what;
    this.exit = exit;
}