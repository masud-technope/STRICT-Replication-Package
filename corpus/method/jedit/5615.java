//}}}
//{{{ generateCache() method
public PluginCacheEntry generateCache() throws IOException {
    properties = new Properties();
    localizationProperties = new HashMap<String, Properties>();
    List<String> classes = new LinkedList<String>();
    List<String> resources = new LinkedList<String>();
    ZipFile zipFile = getZipFile();
    List<String> plugins = new LinkedList<String>();
    PluginCacheEntry cache = new PluginCacheEntry();
    cache.modTime = file.lastModified();
    Enumeration<? extends ZipEntry> entries = zipFile.entries();
    Pattern languageFilePattern = Pattern.compile("lang_(\\w+).properties");
    while (entries.hasMoreElements()) {
        ZipEntry entry = entries.nextElement();
        String name = entry.getName();
        String lname = name.toLowerCase();
        if ("actions.xml".equals(lname)) {
            cache.actionsURI = classLoader.getResource(name);
        } else if ("browser.actions.xml".equals(lname)) {
            cache.browserActionsURI = classLoader.getResource(name);
        } else if ("dockables.xml".equals(lname)) {
            dockablesURI = classLoader.getResource(name);
            cache.dockablesURI = dockablesURI;
        } else if ("services.xml".equals(lname)) {
            servicesURI = classLoader.getResource(name);
            cache.servicesURI = servicesURI;
        } else if (lname.endsWith(".props")) {
            InputStream in = null;
            try {
                in = classLoader.getResourceAsStream(name);
                properties.load(in);
            } finally {
                IOUtilities.closeQuietly((Closeable) in);
            }
        } else if (name.endsWith(".class")) {
            String className = MiscUtilities.fileToClass(name);
            if (className.endsWith("Plugin")) {
                plugins.add(className);
            }
            classes.add(className);
        } else {
            Matcher matcher = languageFilePattern.matcher(lname);
            if (matcher.matches()) {
                String languageName = matcher.group(1);
                Properties props = new Properties();
                InputStream in = null;
                try {
                    in = classLoader.getResourceAsStream(name);
                    CharsetEncoding utf8 = new CharsetEncoding("UTF-8");
                    Reader utf8in = utf8.getTextReader(in);
                    props.load(utf8in);
                    localizationProperties.put(languageName, props);
                } finally {
                    IOUtilities.closeQuietly((Closeable) in);
                }
            } else
                resources.add(name);
        }
    }
    cache.cachedProperties = properties;
    cache.localizationProperties = localizationProperties;
    // this must be done before loading cachedProperties
    if (cache.localizationProperties != null) {
        localizationProperties = cache.localizationProperties;
        String currentLanguage = jEdit.getCurrentLanguage();
        Properties langProperties = localizationProperties.get(currentLanguage);
        if (langProperties != null) {
            jEdit.addPluginLocalizationProps(langProperties);
        }
    }
    jEdit.addPluginProps(properties);
    this.classes = cache.classes = classes.toArray(new String[classes.size()]);
    this.resources = cache.resources = resources.toArray(new String[resources.size()]);
    String label = null;
    for (String className : plugins) {
        String _label = jEdit.getProperty("plugin." + className + ".name");
        String version = jEdit.getProperty("plugin." + className + ".version");
        if (_label == null || version == null) {
            Log.log(Log.WARNING, this, "Ignoring: " + className);
        } else {
            cache.pluginClass = className;
            // is already loaded
            if (!continueLoading(className, cache.cachedProperties)) {
                return null;
            } else {
                EditPlugin otherPlugin = jEdit.getPlugin(className);
                if (otherPlugin != null) {
                    jEdit.removePluginJAR(otherPlugin.getPluginJAR(), false);
                //						otherPlugin.getPluginJAR().uninit(false);
                }
            }
            plugin = new EditPlugin.Deferred(this, className);
            label = _label;
            break;
        }
    }
    boolean isBeingLoaded = jEdit.getPluginJAR(getPath()) != null;
    if (!isBeingLoaded) {
        Log.log(Log.DEBUG, PluginJAR.class, "not loading actions, dockables, services " + "because the plugin is not really being loaded");
        return cache;
    }
    if (cache.actionsURI != null) {
        actions = new ActionSet(this, null, null, cache.actionsURI);
        actions.load();
        cache.cachedActionNames = actions.getCacheableActionNames();
        cache.cachedActionToggleFlags = new boolean[cache.cachedActionNames.length];
        for (int i = 0; i < cache.cachedActionNames.length; i++) {
            cache.cachedActionToggleFlags[i] = jEdit.getBooleanProperty(cache.cachedActionNames[i] + ".toggle");
        }
    }
    if (cache.browserActionsURI != null) {
        browserActions = new ActionSet(this, null, null, cache.browserActionsURI);
        browserActions.load();
        VFSBrowser.getActionContext().addActionSet(browserActions);
        cache.cachedBrowserActionNames = browserActions.getCacheableActionNames();
        cache.cachedBrowserActionToggleFlags = new boolean[cache.cachedBrowserActionNames.length];
        for (int i = 0; i < cache.cachedBrowserActionNames.length; i++) {
            cache.cachedBrowserActionToggleFlags[i] = jEdit.getBooleanProperty(cache.cachedBrowserActionNames[i] + ".toggle");
        }
    }
    if (dockablesURI != null) {
        DockableWindowFactory.getInstance().loadDockableWindows(this, dockablesURI, cache);
    }
    if (actions.size() != 0) {
        if (label != null) {
            actions.setLabel(jEdit.getProperty("action-set.plugin", new String[] { label }));
        } else
            actionsPresentButNotCoreClass();
        jEdit.addActionSet(actions);
    }
    if (servicesURI != null) {
        ServiceManager.loadServices(this, servicesURI, cache);
    }
    return cache;
}