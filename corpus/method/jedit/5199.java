/**
	 * Creates a new plugin update message. This constructor should be used
	 * when the plugin is being removed and the PluginJAR is no longer available.
	 * @param file The file representing the plugin
	 * @param what What happened
	 * @param exit Is the editor exiting?
	 * @since jEdit 4.2pre3
	 */
public  PluginUpdate(File file, Object what, boolean exit) {
    super(file);
    this.file = file;
    if (what == null)
        throw new NullPointerException("What must be non-null");
    this.what = what;
    this.exit = exit;
}