//{{{ unloadPluginJAR() method
/**
		 * This should go into a public method somewhere.
		 * @param jar the jar of the plugin
		 */
private void unloadPluginJAR(PluginJAR jar) {
    String[] dependents = jar.getDependentPlugins();
    for (String path : dependents) {
        PluginJAR _jar = jEdit.getPluginJAR(path);
        if (_jar != null) {
            toLoad.add(path);
            unloadPluginJAR(_jar);
        }
    }
    jEdit.removePluginJAR(jar, false);
//}}}
}