//{{{ unloadPluginJARWithDialog() method
// Perhaps this should also be moved to PluginJAR class?
private void unloadPluginJARWithDialog(PluginJAR jar) {
    // unloaded = new HashSet<String>();
    unloaded = new ConcurrentHashMap<String, Object>();
    String[] dependents = jar.getAllDependentPlugins();
    if (dependents.length == 0) {
        unloadPluginJAR(jar);
    } else {
        List<String> closureSet = new LinkedList<String>();
        dependents = jar.getDependentPlugins();
        PluginJAR.transitiveClosure(dependents, closureSet);
        // remove dupes
        List<String> listModel = new ArrayList<String>(new HashSet<String>(closureSet));
        boolean confirm = true;
        if (!listModel.isEmpty()) {
            // show confirmation dialog listing dependencies to be unloaded
            Collections.sort(listModel, new StandardUtilities.StringCompare<String>(true));
            int button = GUIUtilities.listConfirm(window, "plugin-manager.dependency", new String[] { jar.getFile().getName() }, listModel.toArray());
            confirm = button == JOptionPane.YES_OPTION;
        }
        if (confirm) {
            String[] optionals = jar.getOptionallyDependentPlugins();
            unloadPluginJAR(jar);
            // without this plugin
            for (String opt : optionals) {
                PluginJAR.load(opt, true);
            }
        }
    }
//}}}
}