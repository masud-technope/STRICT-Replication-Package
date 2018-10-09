//}}}
//{{{ unloadDockableWindows() method
/**
	 * Plugins shouldn't need to call this method.
	 * @since jEdit 4.2pre1
	 */
public void unloadDockableWindows(PluginJAR plugin) {
    Iterator entries = dockableWindowFactories.entrySet().iterator();
    while (entries.hasNext()) {
        Map.Entry entry = (Map.Entry) entries.next();
        Window factory = (Window) entry.getValue();
        if (factory.plugin == plugin)
            entries.remove();
    }
}