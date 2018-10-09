//}}}
//{{{ update() method
public void update() {
    List<String> savedSelection = new ArrayList<String>();
    saveSelection(savedSelection);
    entries.clear();
    String systemJarDir = MiscUtilities.constructPath(jEdit.getJEditHome(), "jars");
    String userJarDir;
    String settingsDirectory = jEdit.getSettingsDirectory();
    if (settingsDirectory == null)
        userJarDir = null;
    else {
        userJarDir = MiscUtilities.constructPath(settingsDirectory, "jars");
    }
    PluginJAR[] plugins = jEdit.getPluginJARs();
    for (int i = 0; i < plugins.length; i++) {
        String path = plugins[i].getPath();
        if (path.startsWith(systemJarDir) || (userJarDir != null && path.startsWith(userJarDir))) {
            Entry e = new Entry(plugins[i]);
            if (!hideLibraries.isSelected() || e.clazz != null) {
                entries.add(e);
            }
        }
    }
    String[] newPlugins = jEdit.getNotLoadedPluginJARs();
    for (int i = 0; i < newPlugins.length; i++) {
        Entry e = new Entry(newPlugins[i]);
        entries.add(e);
    }
    sort(sortType);
    restoreSelection(savedSelection);
//}}}
}