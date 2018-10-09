//}}}
//{{{ loadDockableWindows() method
/**
	 * Plugins shouldn't need to call this method.
	 * @since jEdit 4.2pre1
	 */
public void loadDockableWindows(PluginJAR plugin, URL uri, PluginJAR.PluginCacheEntry cache) {
    try {
        Log.log(Log.DEBUG, DockableWindowManager.class, "Loading dockables from " + uri);
        DockableListHandler dh = new DockableListHandler(plugin, uri);
        InputStream in = uri.openStream();
        if (in == null) {
            // this happened when calling generateCache() in the context of 'find orphan jars'
            // in org.gjt.sp.jedit.pluginmgr.ManagePanel.FindOrphan.actionPerformed(ActionEvent)
            // because for not loaded plugins, the plugin will not be added to the list of pluginJars
            // so the org.gjt.sp.jedit.proto.jeditresource.PluginResURLConnection will not find the plugin
            // to read the resource from.
            // Better log a small error message than a big stack trace
            Log.log(Log.WARNING, this, "Unable to open: " + uri);
        } else {
            boolean failure = XMLUtilities.parseXML(in, dh);
            if (!failure && cache != null) {
                cache.cachedDockableNames = dh.getCachedDockableNames();
                cache.cachedDockableActionFlags = dh.getCachedDockableActionFlags();
                cache.cachedDockableMovableFlags = dh.getCachedDockableMovableFlags();
            }
        }
    } catch (IOException e) {
        Log.log(Log.ERROR, DockableWindowManager.class, e);
    }
}