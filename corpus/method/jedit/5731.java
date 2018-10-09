@Override
public void actionPerformed(ActionEvent e) {
    PluginJAR[] pluginJARs = jEdit.getPluginJARs();
    Set<String> neededJars = new HashSet<String>();
    Map<String, String> jarlibs = new HashMap<String, String>();
    for (PluginJAR pluginJAR : pluginJARs) {
        EditPlugin plugin = pluginJAR.getPlugin();
        if (plugin == null) {
            jarlibs.put(new File(pluginJAR.getPath()).getName(), pluginJAR.getPath());
        } else {
            Set<String> strings = plugin.getPluginJAR().getRequiredJars();
            for (String string : strings) {
                neededJars.add(new File(string).getName());
            }
        }
    }
    String[] notLoadedJars = jEdit.getNotLoadedPluginJARs();
    for (int i = 0; i < notLoadedJars.length; i++) {
        PluginJAR pluginJAR = new PluginJAR(new File(notLoadedJars[i]));
        PluginJAR.PluginCacheEntry pluginCacheEntry = PluginJAR.getPluginCache(pluginJAR);
        try {
            if (pluginCacheEntry == null) {
                pluginCacheEntry = pluginJAR.generateCache();
            }
            if (pluginCacheEntry == null) {
                // this happens when, for some reason, two versions
                // of a plugin are installed, e.g when XSLT.jar and
                // xslt.jar are both in $JEDIT_HOME/jars on Linux.
                Log.log(Log.WARNING, ManagePanel.class, "couldn't load plugin " + pluginJAR.getPath() + " (most likely other version exists)");
            }
            if (pluginCacheEntry == null || pluginCacheEntry.pluginClass == null) {
                // Not a plugin
                jarlibs.put(new File(notLoadedJars[i]).getName(), notLoadedJars[i]);
                continue;
            }
            Properties cachedProperties = pluginCacheEntry.cachedProperties;
            String jars = cachedProperties.getProperty("plugin." + pluginCacheEntry.pluginClass + ".jars");
            if (jars != null) {
                neededJars.addAll(PluginJAR.parseJarsFilesStringNames(jars));
            }
        } catch (IOException e1) {
            Log.log(Log.ERROR, this, e);
        }
    }
    List<String> removingJars = new ArrayList<String>();
    Set<String> jarlibsKeys = jarlibs.keySet();
    for (String jar : jarlibsKeys) {
        if (!neededJars.contains(jar)) {
            removingJars.add(jar);
            Log.log(Log.MESSAGE, this, "It seems that this jar do not belong to any plugin " + jar);
        }
    }
    if (removingJars.isEmpty()) {
        GUIUtilities.message(ManagePanel.this, "plugin-manager.noOrphan", null);
        return;
    }
    String[] strings = removingJars.toArray(new String[removingJars.size()]);
    List<String> mustRemove = new ArrayList<String>();
    int ret = GUIUtilities.listConfirm(ManagePanel.this, "plugin-manager.findOrphan", null, strings, mustRemove);
    if (ret != JOptionPane.OK_OPTION || mustRemove.isEmpty())
        return;
    Roster roster = new Roster();
    for (String entry : mustRemove) roster.addRemove(jarlibs.get(entry));
    roster.performOperationsInAWTThread(window);
    pluginModel.update();
    if (table.getRowCount() != 0) {
        table.setRowSelectionInterval(0, 0);
    }
    table.setColumnSelectionInterval(0, 0);
    JScrollBar scrollbar = scrollpane.getVerticalScrollBar();
    scrollbar.setValue(scrollbar.getMinimum());
    table.repaint();
}