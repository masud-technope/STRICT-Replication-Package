//{{{ unloadPluginJAR() method
private void unloadPluginJAR(PluginJAR jar) {
    String[] dependents = jar.getAllDependentPlugins();
    for (String dependent : dependents) {
        if (!unloaded.containsKey(dependent)) {
            unloaded.put(dependent, Boolean.TRUE);
            PluginJAR _jar = jEdit.getPluginJAR(dependent);
            if (_jar != null)
                unloadPluginJAR(_jar);
        }
    }
    jEdit.removePluginJAR(jar, false);
    jEdit.setBooleanProperty("plugin-blacklist." + MiscUtilities.getFileName(jar.getPath()), true);
    jEdit.propertiesChanged();
//}}}
}