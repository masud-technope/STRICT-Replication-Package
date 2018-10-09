//}}}
//{{{ loadCache() method
private boolean loadCache(PluginCacheEntry cache) {
    // is already loaded
    if (cache.pluginClass != null) {
        // is already loaded
        if (!continueLoading(cache.pluginClass, cache.cachedProperties)) {
            return false;
        } else {
            EditPlugin otherPlugin = jEdit.getPlugin(cache.pluginClass);
            if (otherPlugin != null)
                jEdit.removePluginJAR(otherPlugin.getPluginJAR(), false);
        }
    }
    classes = cache.classes;
    resources = cache.resources;
    // this must be done before loading cachedProperties
    if (cache.localizationProperties != null) {
        localizationProperties = cache.localizationProperties;
        String currentLanguage = jEdit.getCurrentLanguage();
        Properties langProperties = localizationProperties.get(currentLanguage);
        if (langProperties != null) {
            jEdit.addPluginLocalizationProps(langProperties);
        }
    }
    /* this should be before dockables are initialized */
    if (cache.cachedProperties != null) {
        properties = cache.cachedProperties;
        jEdit.addPluginProps(cache.cachedProperties);
    }
    if (cache.actionsURI != null && cache.cachedActionNames != null) {
        actions = new ActionSet(this, cache.cachedActionNames, cache.cachedActionToggleFlags, cache.actionsURI);
    }
    if (cache.browserActionsURI != null && cache.cachedBrowserActionNames != null) {
        browserActions = new ActionSet(this, cache.cachedBrowserActionNames, cache.cachedBrowserActionToggleFlags, cache.browserActionsURI);
        String label = jEdit.getProperty("plugin." + cache.pluginClass + ".name");
        browserActions.setLabel(jEdit.getProperty("action-set.plugin", new String[] { label }));
        VFSBrowser.getActionContext().addActionSet(browserActions);
    }
    if (cache.dockablesURI != null && cache.cachedDockableNames != null && cache.cachedDockableActionFlags != null && cache.cachedDockableMovableFlags != null) {
        dockablesURI = cache.dockablesURI;
        DockableWindowFactory.getInstance().cacheDockableWindows(this, cache.cachedDockableNames, cache.cachedDockableActionFlags, cache.cachedDockableMovableFlags);
    }
    if (actions.size() != 0)
        jEdit.addActionSet(actions);
    if (cache.servicesURI != null && cache.cachedServices != null) {
        servicesURI = cache.servicesURI;
        for (int i = 0; i < cache.cachedServices.length; i++) {
            ServiceManager.Descriptor d = cache.cachedServices[i];
            ServiceManager.registerService(d);
        }
    }
    if (cache.pluginClass != null) {
        String label = jEdit.getProperty("plugin." + cache.pluginClass + ".name");
        actions.setLabel(jEdit.getProperty("action-set.plugin", new String[] { label }));
        plugin = new EditPlugin.Deferred(this, cache.pluginClass);
    } else {
        if (actions.size() != 0)
            actionsPresentButNotCoreClass();
    }
    return true;
}