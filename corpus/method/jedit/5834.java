//}}}
//{{{ performOperationsInAWTThread() method
void performOperationsInAWTThread(Component comp) {
    for (Operation op : operations) op.runInAWTThread(comp);
    // require all JARs to be present
    for (String pluginName : toLoad) {
        if (jEdit.getPluginJAR(pluginName) != null)
            Log.log(Log.WARNING, this, "Already loaded: " + pluginName);
        else
            jEdit.addPluginJAR(pluginName);
    }
    for (String pluginName : toLoad) {
        PluginJAR plugin = jEdit.getPluginJAR(pluginName);
        if (plugin != null)
            plugin.checkDependencies();
    }
    // now activate the plugins
    for (String pluginName : toLoad) {
        PluginJAR plugin = jEdit.getPluginJAR(pluginName);
        if (plugin != null)
            plugin.activatePluginIfNecessary();
    }
}