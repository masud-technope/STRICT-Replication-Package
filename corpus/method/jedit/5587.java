//}}}
//{{{ getPlugin() method
/**
	 * Returns the plugin core class for this JAR file. Note that if the
	 * plugin has not been activated, this will return an instance of
	 * {@link EditPlugin.Deferred}. If you need the actual plugin core
	 * class instance, call {@link #activatePlugin()} first.
	 * If the plugin is not yet loaded, returns null
	 *
	 * @since jEdit 4.2pre1
	 */
public EditPlugin getPlugin() {
    return plugin;
}