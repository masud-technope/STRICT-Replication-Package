//}}}
//{{{ load(String jarPath, boolean activateDependentIfNecessary)
/**
	 * Loads a plugin, and its dependent plugins if necessary.
	 *
	 * @since jEdit 4.3pre7
	 */
public static PluginJAR load(String path, boolean loadDependents) {
    PluginJAR jar = jEdit.getPluginJAR(path);
    if (jar != null && jar.getPlugin() != null) {
        return jar;
    }
    jEdit.addPluginJAR(path);
    jar = jEdit.getPluginJAR(path);
    if (jar == null)
        return null;
    EditPlugin plugin = jar.getPlugin();
    if (plugin == null) {
        // No plugin, maybe it is a library
        return jar;
    }
    String className = plugin.getClassName();
    if (loadDependents) {
        Set<String> pluginLoadList = getDependencySet(className);
        for (String jarName : pluginLoadList) {
            String jarPath = findPlugin(jarName);
            if (jarPath == null) {
                Log.log(Log.WARNING, PluginJAR.class, "Unable to load dependency " + jarName + " the plugin is not installed");
                continue;
            }
            load(jarPath, true);
        }
    }
    // Load extra jars that are part of this plugin
    Collection<String> jarsPaths = jar.getJars();
    for (String _jarPath : jarsPaths) {
        PluginJAR _jar = jEdit.getPluginJAR(_jarPath);
        if (_jar == null) {
            jEdit.addPluginJAR(_jarPath);
        }
    }
    jar.checkDependencies();
    jar.activatePluginIfNecessary();
    jEdit.propertiesChanged();
    // check all other installed plugins to see if any of them  
    // use me. Reload those that do so the classloaders work together.
    PluginJAR[] installedPlugins = jEdit.getPluginJARs();
    for (PluginJAR installed : installedPlugins) {
        if (installed == null || installed.equals(jar)) {
            continue;
        }
        EditPlugin ep = installed.getPlugin();
        if (ep == null) {
            continue;
        }
        String installedClassname = ep.getClassName();
        PluginDepends[] deps = getPluginDepends(installedClassname);
        for (PluginDepends dep : deps) {
            if ("plugin".equals(dep.what) && className.equals(dep.name)) {
                String reloadPath = ep.getPluginJAR().getPath();
                jEdit.removePluginJAR(ep.getPluginJAR(), false);
                load(reloadPath, true);
            }
        }
    }
    return jar;
}