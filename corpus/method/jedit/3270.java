/**
		 * @param plugin - the pluginJAR for which we are loading the dockables.xml
		 * @param uri - the uri of the dockables.xml file?
		 */
 DockableListHandler(PluginJAR plugin, URL uri) {
    this.plugin = plugin;
    this.uri = uri;
    stateStack = new Stack<String>();
    actions = true;
    movable = MOVABLE_DEFAULT;
    code = new StringBuilder();
    cachedDockableNames = new LinkedList<String>();
    cachedDockableActionFlags = new LinkedList<Boolean>();
    cachedDockableMovableFlags = new LinkedList<Boolean>();
//}}}
}