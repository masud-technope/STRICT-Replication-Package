@Override
public void actionPerformed(ActionEvent evt) {
    int[] selected = table.getSelectedRows();
    List<String> listModel = new LinkedList<String>();
    Roster roster = new Roster();
    Set<String> jarsToRemove = new HashSet<String>();
    // this one will contains the loaded jars to remove. They
    // are the only one we need to check to unload plugins
    // that depends on them
    Set<String> loadedJarsToRemove = new HashSet<String>();
    for (int i = 0; i < selected.length; i++) {
        Entry entry = pluginModel.getEntry(selected[i]);
        if (entry.status.equals(Entry.NOT_LOADED) || entry.status.equals(Entry.DISABLED)) {
            if (entry.jar != null) {
                try {
                    Collection<String> jarList = getDeclaredJars(entry.jar);
                    jarsToRemove.addAll(jarList);
                } catch (IOException e) {
                    Log.log(Log.ERROR, this, e);
                }
            }
        } else {
            jarsToRemove.addAll(entry.jars);
            loadedJarsToRemove.addAll(entry.jars);
        }
        table.getSelectionModel().removeSelectionInterval(selected[i], selected[i]);
    }
    for (String jar : jarsToRemove) {
        if (new File(jar).exists()) {
            listModel.add(jar);
            roster.addRemove(jar);
        }
    }
    Object[] sortedConfirm = listModel.toArray();
    Arrays.sort(sortedConfirm);
    int button = GUIUtilities.listConfirm(window, "plugin-manager.remove-confirm", null, sortedConfirm);
    if (button == JOptionPane.YES_OPTION) {
        List<String> closureSet = new ArrayList<String>();
        PluginJAR.transitiveClosure(loadedJarsToRemove.toArray(new String[loadedJarsToRemove.size()]), closureSet);
        closureSet.removeAll(listModel);
        if (closureSet.isEmpty()) {
            button = JOptionPane.YES_OPTION;
        } else {
            button = GUIUtilities.listConfirm(window, "plugin-manager.remove-dependencies", null, closureSet.toArray());
            Collections.sort(closureSet, new StandardUtilities.StringCompare<String>(true));
        }
        if (button == JOptionPane.YES_OPTION) {
            for (String jarName : closureSet) {
                PluginJAR pluginJAR = jEdit.getPluginJAR(jarName);
                jEdit.removePluginJAR(pluginJAR, false);
            }
            roster.performOperationsInAWTThread(window);
            pluginModel.update();
            if (table.getRowCount() != 0) {
                table.setRowSelectionInterval(0, 0);
            }
            table.setColumnSelectionInterval(0, 0);
            JScrollBar scrollbar = scrollpane.getVerticalScrollBar();
            scrollbar.setValue(scrollbar.getMinimum());
        }
    }
    PluginManager.getInstance().pluginRemoved();
}