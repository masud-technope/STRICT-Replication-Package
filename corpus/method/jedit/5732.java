/**
		 * @return A list of the names of the dependencies, e.g. ErrorList or ProjectViewer.
		 */
public Set<String> getDependencies() {
    if (plugin == null)
        return null;
    Set<String> depends = null;
    PluginJAR jar = plugin.getPluginJAR();
    String cn = plugin.getClassName();
    Set<String> requiredJars = jar.getDependencies(cn);
    if (requiredJars != null && !requiredJars.isEmpty()) {
        depends = new HashSet<String>();
        for (String dep : requiredJars) {
            Entry e = pluginModel.getEntry(dep);
            if (e != null)
                depends.add(e.name);
        }
    }
    return depends;
}